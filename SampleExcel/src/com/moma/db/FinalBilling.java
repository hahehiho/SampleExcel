package com.moma.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.moma.dbo.ActualDO;
import com.moma.dbo.ClearDBDO;
import com.moma.dbo.FinalBillingRow;
import com.moma.dbo.ProductMapDO;
import com.moma.dbo.SapDBDO;

public class FinalBilling {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String resource = "com/moma/db/dbconf.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<ProductMapDO> productMapList = sqlSession.selectList("selectProductMapAll");
		Map<String, ProductMapDO> productMap = new HashMap<>();
		for (ProductMapDO productMapDO : productMapList) {
			productMap.put(productMapDO.getName(), productMapDO);
		}
		
		List<ActualDO> actualList = sqlSession.selectList("selectActualByQuarter", "FY17");
		FinalBillingRow prevFirstRow = null;
		
		ArrayList<FinalBillingRow> result = new ArrayList<>();
		System.out.println("actual size : " + actualList.size());
		int x = -1;
		for (ActualDO actual : actualList) {
			x++;
			
			FinalBillingRow row = new FinalBillingRow();
			
			/* from actual */
			row.setWeek(actual.getWeek());
			row.setQuarter(actual.getQuarter());
			row.setMonth(actual.getMonth());
			row.setSerialNumber(actual.getSn());
			row.setPo(actual.getPo());
			row.setProgram(actual.getProgram());
			row.setLeadSource(actual.getLeadsource());
			row.setPartner(actual.getPartner());
			row.setLeadSourceName(actual.getLeadsourcename());
			row.setFullfillmentChannel(actual.getFullfillmentchannel());
			row.setProgramAPAC(actual.getProgram());
			
			result.add(row);
			
			
			/* from cleardb */
			List<ClearDBDO> clearDB = sqlSession.selectList("selectClearDBBySN", actual.getSn());
			if(clearDB.size() == 0) {
				System.out.println("invalid SN = " + actual.getSn());
				continue;
			}
			System.out.println("cleardb size : " + clearDB.size());
			
			ClearDBDO cdbo = clearDB.get(0);

			if(prevFirstRow != null) {
				if(!prevFirstRow.getPo().equals(row.getPo())) {
					prevFirstRow = row;
				} else {
					row.copy(prevFirstRow);
					prevFirstRow.setQuantity(prevFirstRow.getQuantity()+cdbo.getNoofseats());
					continue;
				}
			} else {
				prevFirstRow = row;
			}

			row.setCompanyName(cdbo.getEnduseraccountname());
			row.setCity(cdbo.getCity());
			if(cdbo.getLicensemodel().equalsIgnoreCase("TERM")) 
				row.setLicenseType("DTS");
			else
				row.setLicenseType(cdbo.getLicensetype());
			if(cdbo.getDeploymenttype().equalsIgnoreCase("Standalone"))
				row.setDeployment("SLM");
			else
				row.setDeployment("NLM");
			row.setQuantity(cdbo.getNoofseats());
			ProductMapDO pd = productMap.get(cdbo.getProductline());
			row.setProduct(pd.getName());
			row.setDivision(pd.getDivision());
			row.setSuite(pd.getSuite());
			
			/* from sapdb */
			long productTotal = 0;
			long subTotal = 0;

			boolean isTermBndl = false;
			List<SapDBDO> sapDB = sqlSession.selectList("selectSapDBByPO", actual.getPo());
			System.out.println("sapdb size : " + sapDB.size() + ", po = " + actual.getPo());

			for (SapDBDO sapDBDO : sapDB) {
				if(sapDBDO.getMaterialgroup().equalsIgnoreCase("TERM_BNDL"))
					isTermBndl = true;
			}
			
			for (SapDBDO sapDBDO : sapDB) {
				if(sapDBDO.getMaterialgroup().equalsIgnoreCase("TERM_BNDL")) {
					subTotal += sapDBDO.getItemnetvalue();
				} else if(!isTermBndl && sapDBDO.getMaterialgroup().equalsIgnoreCase("TERM_LIC")) {
					 
				} else if(!isTermBndl && sapDBDO.getMaterialgroup().equalsIgnoreCase("SUBSCRPTN")) {
					subTotal += sapDBDO.getItemnetvalue();
				} else if(sapDBDO.getMaterialgroup().equalsIgnoreCase("LICENSE")) {
					productTotal += sapDBDO.getItemnetvalue();
				}
			}
			
			row.setProductTotal(productTotal);
			row.setSubTotal(subTotal);
			if(subTotal > 0) {
				row.setSub("Y");
			} else {
				row.setSub("N");
			}
			
			row.setTotalBilling(row.getProductTotal() + row.getSubTotal());
			row.setLegalization(row.getTotalBilling());
			
			System.out.println("progress" + x);

		}

		for (FinalBillingRow row : result) {
			System.out.println(row);
		}
	}
}

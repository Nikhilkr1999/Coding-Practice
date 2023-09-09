package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * String[][] input = new String[][] {
		 * {"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},
		 * {"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},
		 * {"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},
		 * {"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},
		 * {"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}
		 * 
		 * };
		 */
		
			String[][] input = new String[][]	{{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
		List<List<String>> inputList = Arrays.stream(input)
                .map(Arrays::asList)
                .collect(Collectors.toList());
		AccountMerge acc = new AccountMerge();
		inputList = acc.accountsMerge(inputList);
		System.out.println(inputList);
	}

	class Accounts {
		int index;
		Set<String> set;
		String name;
		public Accounts() {

		}
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<Accounts> resultLists = new ArrayList<Accounts>();

		Map<String, Accounts> emailMap = new HashMap<String, Accounts>();

		for (int i = 0; i < accounts.size(); i++) {
			List<String> emails = accounts.get(i);
			populateMap1(emails, emailMap, resultLists);

		}
		List<List<String>> finalResultSet = new ArrayList<List<String>>();
		for(Accounts account : resultLists) {
			System.out.println(account.name);
			List<String> emails = new ArrayList<String>();
			emails.add(account.name);
			List<String> email = new ArrayList<String>(account.set);
			Collections.sort(email);
			emails.addAll(email);
			finalResultSet.add(emails);
		}
		return finalResultSet;
	}

	public void populateMap1(List<String> emails, Map<String, Accounts> emailMap, List<Accounts> resultLists) {
		Accounts account = new Accounts();
		boolean isExistingAccount = false;
		String name = emails.get(0);
		Set<String> mailSet = new HashSet<String>();
		int i;
		for (i = 1; i < emails.size(); i++) {
			String email = emails.get(i);
			if (emailMap.containsKey(email)) {
				account = emailMap.get(email);
				isExistingAccount = true;
			} else {
				System.out.println(email);
				
				mailSet.add(email);
			}
		}
		if(isExistingAccount) {
			account.set.addAll(mailSet);
			
			
			//Collections.sort(existingResultList);
			resultLists.set(account.index, account);
		} else {
			int resultSize = resultLists.size();
			account.index = resultSize;
			account.set = mailSet;
			account.name = name;
			List<String> emailList = new ArrayList<String>(mailSet);
			
			for (i = 0; i < emailList.size(); i++) {
				emailMap.put(emailList.get(i), account);
			}
			resultLists.add(resultSize, account);
		}
	}
	
	public void populateMap(List<String> emails, Map<String, Accounts> emailMap, List<List<String>> resultLists) {
		Accounts account = new Accounts();
		Accounts existingAccount = null;
		String name = emails.get(0);
		Set<String> localEmail = new HashSet<String>();
		for (int i = 1; i < emails.size(); i++) {
			localEmail.add(emails.get(i));
		}
		int i;
		List<String> localEmailList = new ArrayList<String>(localEmail);
		Iterator<String> iter = localEmail.iterator();
		while(iter.hasNext()) {
			String email = iter.next();
			if (emailMap.containsKey(email)) {
				existingAccount = emailMap.get(email);
				localEmail.remove(email);
				
			}
		}
		for (i = 1; i < localEmailList.size(); i++) {
			String email = localEmailList.get(i);
			if (emailMap.containsKey(email)) {
				existingAccount = emailMap.get(email);
				localEmail.remove(email);
				
			}
		}

		if (existingAccount != null) {
			List<String> existingResultList = resultLists.get(existingAccount.index);
			
			existingResultList.addAll(localEmailList);
			
			Collections.sort(existingResultList);
			resultLists.set(existingAccount.index, existingResultList);
		} else {
			int resultSize = resultLists.size();
			account.index = resultSize;
			localEmailList = new ArrayList<String>(localEmail);
			localEmailList.add(0, name);
			for (i = 1; i < localEmailList.size(); i++) {
				emailMap.put(localEmailList.get(i), account);
			}
			Collections.sort(localEmailList);
			resultLists.add(resultSize, localEmailList);

		}

	}
}

package com.proj.stringFrequency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StringFrequencyCheck
{
	public static void main(String[] args) throws IOException
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("enter the no of elements you want to add");
		String s1 = scn.nextLine();
		int i1 = Integer.parseInt(s1);
		String[] arr = new String[i1];
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println("enter the" + i + "th element");
			arr[i] = scn.nextLine();
		}
		List<String> ls = new ArrayList<String>();
		for (String s : arr)
			ls.add(s);
		Map<String, Integer> m1 = new TreeMap<String, Integer>();
		for (String s : arr)
		{
			int i = Collections.frequency(ls, s);
			m1.put(s, i);
		}
		System.out.println(m1);
		ValueComparator bvc = new ValueComparator(m1);
		TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
		sorted_map.putAll(m1);
		for (Map.Entry<String, Integer> ele : sorted_map.entrySet())
		{
			System.out.println(ele.getKey());
		}
		if (scn != null)
			scn.close();
	}
}

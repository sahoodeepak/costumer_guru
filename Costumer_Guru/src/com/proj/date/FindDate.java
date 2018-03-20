package com.proj.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FindDate
{
	public static void main(String... args) throws Exception
	{
		DateFormat sdf;
		Date next;
		while(true) {
		try
		{
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.println(
					"enter a date in dd/mm/yyyy format to find its first date of month");
			String firstDate = br.readLine();

			System.out.println(
					"enter a date in dd/mm/yyyy format to find its last date of month");
			String lastDate = br.readLine();
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date today = sdf.parse(firstDate);
			System.out.println(
					"First Day of the given month: " + getFirstDateOfMonth(today));

			next = sdf.parse(lastDate);
			break;
		} catch (Exception e)
		{
			System.out.println("plz give valid input");
		}
		}

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		String strDate = dateFormat.format(date);

		// System.out.println("Converted String: " + strDate);
		Date today1 = sdf.parse(strDate);
		if (next.after(today1))
		{
			System.out.println("Last of the given month: " + new Date());
		} else
		{
			if (getLastDateOfMonth(next).after(today1))
			{
				System.out.println("Last of the given month: " + new Date());
				return;
			}
			System.out.println(
					"Last of the given month: " + getLastDateOfMonth(next));
		}
	}

	public static Date getFirstDateOfMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	public static Date getLastDateOfMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
}

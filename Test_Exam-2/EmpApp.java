package Emps;

import java.util.*;

class Emp
{
    String name;
    String job;
    int sal;
    String doj;

    Emp(String name, String job, int sal, String doj)
    {
        this.name = name;
        this.job = job;
        this.sal = sal;
        this.doj = doj;
    }
}

public class EmpApp
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Emp> empList = new ArrayList<>();

    public static void main(String[] args)
    {
        int ch = 0;

        while (ch != 6)
        {
            System.out.println("MENU:");
            System.out.println("1.add emp");
            System.out.println("2.sal asc");
            System.out.println("3.sal desc");
            System.out.println("4.doj asce");
            System.out.println("5.doj desc");
            System.out.println("6.exit");
            System.out.print("enter choce:");
            ch = sc.nextInt();

            switch (ch)
            {
                case 1:addEmp();break;
                case 2:salAsc();break;
                case 3:salDesc();break;
                case 4:dojAsc();break;
                case 5:dojDesc();break;
                case 6:System.out.println("exit");break;
                default:System.out.println("wrong choice");
            }
        }
    }

    // 1 -- add emp
    static void addEmp()
    {
        System.out.print("enter name:");
        String name = sc.next();

        System.out.print("enter job:");
        String job = sc.next();

        System.out.print("enter sal:");
        int sal = sc.nextInt();

        System.out.print("enter doj:");
        String doj = sc.next();

        Emp e = new Emp(name, job, sal, doj);
        empList.add(e);

        System.out.println("emp added");
    }

    // 2 -- sal asc
    static void salAsc()
    {
        Collections.sort(empList, new Comparator<Emp>() {
            public int compare(Emp e1, Emp e2)
            {
                return e1.sal - e2.sal;
            }
        });

        System.out.println("sal-asc");
        showEmp();
    }

    // 3 -- saldesc
    static void salDesc()
    {
        Collections.sort(empList, new Comparator<Emp>() {
            public int compare(Emp e1, Emp e2)
            {
                return e2.sal - e1.sal;
            }
        });

        System.out.println("sal-desc");
        showEmp();
    }

    // 4 -- doj asc
    static void dojAsc()
    {
        Collections.sort(empList, new Comparator<Emp>() {
            public int compare(Emp e1, Emp e2)
            {
                return e1.doj.compareTo(e2.doj);
            }
        });

        System.out.println("doj asc");
        showEmp();
    }

    // 5 -- doj desc
    static void dojDesc()
    {
        Collections.sort(empList, new Comparator<Emp>() {
            public int compare(Emp e1, Emp e2)
            {
                return e2.doj.compareTo(e1.doj);
            }
        });

        System.out.println("dojdesc-");
        showEmp();
    }

    // show emp
    static void showEmp()
    {
        System.out.println("emp list:");

        for (Emp e:empList)
        {
            System.out.println(e.name +" "+  e.job +" "+e.sal+" "+ e.doj);
        }
    }
}


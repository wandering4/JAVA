package view;

import dao.impl.DeptDaoImpl;
import dao.impl.EmpDaoImpl;
import pojo.Dept;
import pojo.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author: xuzifan
 * @Date: 2024/1/27 - 01 - 27 - 0:48
 * @Description: view
 * @version: 1.0
 */
public class StartSystem {
    static  Scanner cd=new Scanner(System.in);
    private static String pattern = "yyyy-MM-dd"; // 日期字符串的格式
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    private static EmpDaoImpl emp=new EmpDaoImpl();
    private static DeptDaoImpl dept=new DeptDaoImpl();

    private StartSystem() {
    }

    public static void deptAll() {
        System.out.println("所有的部门为:");
        Iterator<Dept> iterator = dept.findAll().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void insertEmp() {
        Scanner cd=new Scanner(System.in);
        System.out.println("请输入员工姓名：");
        String ename=cd.next();
        System.out.println("请输入员工职务：");
        String job=cd.next();
        System.out.println("请输入员工领导编号:");
        Integer mgr= null;
        if(cd.hasNextInt()){
            mgr = cd.nextInt();}else{
            cd.next();
        }
        System.out.println("请输入员工入职日期(日期格式形如:"+pattern+")：");
        String da=cd.next();
        try {
            Date date=dateFormat.parse(da);
            System.out.println("请输入员工薪资:");
            double sal=cd.nextDouble();
            System.out.println("请输入员工奖金:");
            double comm=cd.nextDouble();
            System.out.println("请输入部门编号:");
            int deptno=cd.nextInt();
            System.out.println("影响的行数为:" +emp.insert(new Emp(ename,job,mgr,date,sal,comm,deptno)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void empAll() {
        System.out.println("所有的员工为:");
        Iterator<Emp> iterator = emp.findAll().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void deleteEmp(int empno) {
        System.out.println("影响的行数为:"+emp.delete(empno));
    }
    public static void modify(){
        int empno;
        Scanner cd=new Scanner(System.in);
        System.out.print("请输入员工编号：");
        empno=cd.nextInt();
        System.out.println("请输入员工姓名：");
        String ename=cd.next();
        System.out.println("请输入员工职务：");
        String job=cd.next();
        System.out.println("请输入员工领导编号:");
        Integer mgr= null;
        if(cd.hasNextInt()){
            mgr = cd.nextInt();}else{
            cd.next();
        }
        System.out.println("请输入员工入职日期(日期格式形如:"+pattern+")：");
        String da=cd.next();
        try {
            Date date=dateFormat.parse(da);
            System.out.println("请输入员工薪资:");
            double sal=cd.nextDouble();
            System.out.println("请输入员工奖金:");
            double comm=cd.nextDouble();
            System.out.println("请输入部门编号:");
            int deptno=cd.nextInt();
            cd.close();
            System.out.println("影响的行数为:" +emp.modify(new Emp(empno,ename,job,mgr,date,sal,comm,deptno)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // 如果是Windows系统
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // 如果是Unix/Linux系统
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void pause() {
        System.out.println("Press Enter to continue...");

        // 使用Scanner等待用户输入
        cd.nextLine();
    }

    public static void insertDept(){
        System.out.println("请输入部门编号:");
        int deptno=cd.nextInt();
        System.out.println("请输入部门名称:");
        String dname=cd.next();
        System.out.println("请输入部门的位置:");
        String loc=cd.next();
        System.out.println("影响的行数为:"+dept.insert(new Dept(deptno, dname, loc)));
    }
    public static void menu(){
        clearScreen();
        System.out.println("***********************************");
        System.out.println("***\t欢迎使用员工管理系统\t\t\t***");
        System.out.println("* 1.查看所有员工信息\t\t\t\t  *");
        System.out.println("* 2.查看所有部门信息\t\t\t\t  *");
        System.out.println("* 3.根据工号删除员工信息\t\t\t  *");
        System.out.println("* 4.根据工号修改员工信息\t\t\t  *");
        System.out.println("* 5.增加员工信息\t\t\t\t\t  *");
        System.out.println("* 6.增加部门信息\t\t\t\t\t  *");
        System.out.println("* 7.退出\t\t\t\t\t\t  *");
        System.out.println("***********************************");
    }


    //这是一个main方法程序的入口
    public static void main(String[] args) {
        Scanner cd = new Scanner(System.in);
        in:
        while (true) {
            menu();
            System.out.print("请输入选项:");

            int empno;
            int option = cd.nextInt();
            switch (option) {
                case 1:
                    empAll(); pause();
                    break;
                case 2:
                    deptAll(); pause();
                    break;
                case 3:
                    System.out.print("请输入员工编号：");
                    empno = cd.nextInt();
                    deleteEmp(empno);
                    pause();
                    break;
                case 4:
                    modify(); pause();
                    break;
                case 5:
                    insertEmp(); pause();
                    break;
                case 6:
                    insertDept(); pause();
                    break;
                case 7:
                    System.out.println("感谢使用员工管理系统");
                    break in;
                default:
                    System.out.println("请输入正确的数字!");
                    break;
            }

        }
cd.close();
    }
}

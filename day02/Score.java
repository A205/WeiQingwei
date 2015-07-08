//package Day02;

import java.util.Random;

public class Score {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] score = new int[20][5];//建立成绩数组
		//建立课程数组并赋值		
		String[] className = {"项目","core C++","coreJava","Servlet     ","JSP     ","EJB     "};
		String[] studentName = new String[20];//建立学生数组		
		for (int i=0;i<20;i++)//给学生命名
		{
			studentName[i] = "Stud"+(i+1);
		}
		//随机的给没门课程成绩
		Random rand = new Random();
		for(int i=0;i<score.length;i++)
		{
			for(int j=0;j<score[1].length;j++)
			{
				score[i][j] = rand.nextInt(100);
			}
		}
		//以表格形式输出
		System.out.println("学生的成绩如下表：");
		for(int i=0;i<className.length;i++)
		{
			System.out.print(className[i]+"\t");
		}
		System.out.print("\r");
		for(int i=0;i<studentName.length;i++)
		{
			System.out.print(studentName[i]+"\t");
			for (int j=0;j<score[i].length;j++)
			{
				System.out.print(String.valueOf(score[i][j])+"       \t");
			}
			System.out.print("\r");
		}
		//每个学员的总分
		System.out.println("学员的总分成绩依次为：");
		int[] studentTotalScore = new int[studentName.length];
		//System.out.println(studentTotalScore[1]);
		for(int i=0;i<studentName.length;i++)
		{
			for(int j=0;j<score[i].length;j++)
			{
				studentTotalScore[i] = studentTotalScore[i] + score[i][j];
			}
			System.out.print(studentName[i]+"\t");
			System.out.print(studentTotalScore[i]);
			System.out.println();
		}
		//每门课的平均分
		System.out.println("课程的平均成绩依次为：");
		int[]averageScore = new int[score[1].length];
		for(int i=0;i<score[1].length;i++)
		{
			for(int j=0;j<score.length;j++)
			{
				averageScore[i] = averageScore[i] + score[j][i];
			}
			averageScore[i] = averageScore[i]/score.length;
			System.out.print(className[i+1]+"\t");
			System.out.print(averageScore[i]);
			System.out.println();
		}

		

	}

}

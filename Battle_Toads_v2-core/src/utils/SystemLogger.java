package utils;

public class SystemLogger
{

	public SystemLogger()
	{
		System.out.println("Logger initiated...");
	}
	
	static public void Log(String msg)
	{
		StackTraceElement[] e;
		e = Thread.currentThread().getStackTrace();
		System.out.println("[ERROR]: " + e[2].getClassName() + " : " + msg);
	}
	
}

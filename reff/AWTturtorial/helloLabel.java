<<<<<<< HEAD
/* @function:使用者登入介面實現，跳轉到監測資料介面
 */
import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class helloLabel extends JFrame{
	private static int count=0;
	private static JButton bt1;//登陸按鈕
	private static JButton bt2;//忘記密碼按鈕
	private static JLabel jl_1;//登入的版面
	private static JFrame jf_1;//登陸的框架
    private static JTextField jtext1;//使用者名稱
    private static JPasswordField jtext2;//密碼
    private static JLabel jl_admin;
    private static JLabel jl_password;
    public helloLabel (){//初始化登陸介面
    	Font font =new Font("黑體", Font.PLAIN, 20);//設定字型
	    jf_1=new JFrame("登陸介面");
		jf_1.setSize(450, 400);
		//給登陸介面新增背景圖片
		ImageIcon bgim = new ImageIcon(helloLabel.class.getResource("baozou.PNG")) ;//背景圖案
		bgim.setImage(bgim.getImage().
				                     getScaledInstance(bgim.getIconWidth(),
												       bgim.getIconHeight(), 
												       Image.SCALE_DEFAULT));  
		jl_1=new JLabel();
		jl_1.setIcon(bgim);
		
		jl_admin=new JLabel("使用者名稱");
		jl_admin.setBounds(20, 50, 60, 50);
		jl_admin.setFont(font);
		
		jl_password=new JLabel("密碼");
		jl_password.setBounds(20, 120, 60, 50);
		jl_password.setFont(font);
		
		bt1=new JButton("登陸");         //更改成loginButton
		bt1.setBounds(90, 250, 100, 50);
		bt1.setFont(font);

		bt2=new JButton("退出");
		bt2.setBounds(250, 250, 100, 50);
		bt2.setFont(font);

		//加入文字框
		jtext1=new JTextField("root");
		jtext1.setBounds(150, 50, 250, 50);
		jtext1.setFont(font);
		
		jtext2=new JPasswordField("123456");//密碼輸入框
		jtext2.setBounds(150, 120, 250, 50);
		jtext2.setFont(font);
		
		jl_1.add(jtext1);
		jl_1.add(jtext2);
		
		jl_1.add(jl_admin);
		jl_1.add(jl_password);
		jl_1.add(bt1);
		jl_1.add(bt2);
		
		jf_1.add(jl_1);
		jf_1.setVisible(true);
		jf_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_1.setLocation(300,400);
	}
	public static void main(String[] args) {
		//初始化登陸介面
		 
		helloLabel hl =new helloLabel();
		/**
		 * 處理點選事件
		 * 1.登陸按鈕點選事件，判斷賬號密碼是否正確，若正確，彈出監測資訊介面
		 * 否則，無響應（暫時無響應）
		 * ：後可在登陸介面新增一個logLabel提示使用者是否使用者密碼正確
		 * 2.退出按鈕，直接退出程式
		 */
		//登陸點選事件
		ActionListener bt1_ls=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String admin=jtext1.getText();
				char[] password=jtext2.getPassword();
				String str=String.valueOf(password); //將char陣列轉化為string型別
				
				if(admin.equals("root")&&str.equals("123456"))
				{
					   
					System.out.println(admin);
					System.out.println(str);
					mainLayout ml=new mainLayout();//為跳轉的介面
					hl.jf_1.dispose();//銷燬當前介面
				}
				else {
					count++;
					System.out.println("error");
					if(count==3){
						hl.jf_1.dispose();
					}
				}
			}
		};
		bt1.addActionListener(bt1_ls);
		//退出事件的處理
		ActionListener bt2_ls=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);//終止當前程式
			}
		};
        bt2.addActionListener(bt2_ls);		
     }
=======
/* @function:使用者登入介面實現，跳轉到監測資料介面
 */
import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class helloLabel extends JFrame{
	private static int count=0;
	private static JButton bt1;//登陸按鈕
	private static JButton bt2;//忘記密碼按鈕
	private static JLabel jl_1;//登入的版面
	private static JFrame jf_1;//登陸的框架
    private static JTextField jtext1;//使用者名稱
    private static JPasswordField jtext2;//密碼
    private static JLabel jl_admin;
    private static JLabel jl_password;
    public helloLabel (){//初始化登陸介面
    	Font font =new Font("黑體", Font.PLAIN, 20);//設定字型
	    jf_1=new JFrame("登陸介面");
		jf_1.setSize(450, 400);
		//給登陸介面新增背景圖片
		ImageIcon bgim = new ImageIcon(helloLabel.class.getResource("baozou.PNG")) ;//背景圖案
		bgim.setImage(bgim.getImage().
				                     getScaledInstance(bgim.getIconWidth(),
												       bgim.getIconHeight(), 
												       Image.SCALE_DEFAULT));  
		jl_1=new JLabel();
		jl_1.setIcon(bgim);
		
		jl_admin=new JLabel("使用者名稱");
		jl_admin.setBounds(20, 50, 60, 50);
		jl_admin.setFont(font);
		
		jl_password=new JLabel("密碼");
		jl_password.setBounds(20, 120, 60, 50);
		jl_password.setFont(font);
		
		bt1=new JButton("登陸");         //更改成loginButton
		bt1.setBounds(90, 250, 100, 50);
		bt1.setFont(font);

		bt2=new JButton("退出");
		bt2.setBounds(250, 250, 100, 50);
		bt2.setFont(font);

		//加入文字框
		jtext1=new JTextField("root");
		jtext1.setBounds(150, 50, 250, 50);
		jtext1.setFont(font);
		
		jtext2=new JPasswordField("123456");//密碼輸入框
		jtext2.setBounds(150, 120, 250, 50);
		jtext2.setFont(font);
		
		jl_1.add(jtext1);
		jl_1.add(jtext2);
		
		jl_1.add(jl_admin);
		jl_1.add(jl_password);
		jl_1.add(bt1);
		jl_1.add(bt2);
		
		jf_1.add(jl_1);
		jf_1.setVisible(true);
		jf_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_1.setLocation(300,400);
	}
	public static void main(String[] args) {
		//初始化登陸介面
		 
		helloLabel hl =new helloLabel();
		/**
		 * 處理點選事件
		 * 1.登陸按鈕點選事件，判斷賬號密碼是否正確，若正確，彈出監測資訊介面
		 * 否則，無響應（暫時無響應）
		 * ：後可在登陸介面新增一個logLabel提示使用者是否使用者密碼正確
		 * 2.退出按鈕，直接退出程式
		 */
		//登陸點選事件
		ActionListener bt1_ls=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String admin=jtext1.getText();
				char[] password=jtext2.getPassword();
				String str=String.valueOf(password); //將char陣列轉化為string型別
				
				if(admin.equals("root")&&str.equals("123456"))
				{
					   
					System.out.println(admin);
					System.out.println(str);
					mainLayout ml=new mainLayout();//為跳轉的介面
					hl.jf_1.dispose();//銷燬當前介面
				}
				else {
					count++;
					System.out.println("error");
					if(count==3){
						hl.jf_1.dispose();
					}
				}
			}
		};
		bt1.addActionListener(bt1_ls);
		//退出事件的處理
		ActionListener bt2_ls=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);//終止當前程式
			}
		};
        bt2.addActionListener(bt2_ls);		
     }
>>>>>>> 0fd1403fa574305a05989c9525289373b41751d0
}
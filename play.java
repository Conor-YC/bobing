import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class play implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nums = JOptionPane.showInputDialog("输入玩家人数(1~5)\nEnter the number of players","Enter");
		int num = Integer.parseInt(nums);
		String name[] = new String[num];
		for(int i = 0; i < num; i++) {
			String str = "输入第"+(i+1)+"个玩家名字\nEnter the name of player"+(i+1);
			name[i] = JOptionPane.showInputDialog(str,"Enter");
		}
		shake(num,name);
	}
	public void shake(int num, String[] name) {
		int dice[][] = new int[num][6];		
		String result[] = new String[num];		
		String di = "";
		for(int i = 0; i < num; i++){
			for(int j = 0; j < 6; j++) {
				dice[i][j] = (int)(Math.random()*6) + 1;
				di = di +", "+dice[i][j];	
			}
			System.out.println(di);
			di+="|";
		}
		result = Statistics(dice, num);
		for(int i = 0; i < num; i++) {
			System.out.println(result[i]);
		}
		String str = "<html><body>";
		//ImageIcon resultImage[] = new ImageIcon[num];
		for(int i = 0; i < num; i++) {
			str += "玩家" + name[i] + " 中：" + result[i] + "<br>";
			//resultImage[i] = new ImageIcon("D:\\BOBING-IMAGE\\"+result[i]+".png");
		}
		
		str += "<body></html>";
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame jf = new JFrame("Bobing");
		jf.setSize(526, 708);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(); 
		placeComponents(panel, num, name, jf);
		/*JLabel label0 = new JLabel("<html><body>Bobing beta1.23.0<br>Made by Yuke Chen<body></html>",JLabel.RIGHT);
		Font f0 = new Font("隶书",Font.PLAIN,15);
		label0.setFont(f0);
		label0.setForeground(Color.blue);
		label0.setBounds(400, 670, 100, 40);
		panel.add(label0);*/
		//jf.getContentPane().setBackground(new Color(250, 0, 0));
		JLabel label1 = new JLabel("结果榜");
		Font f1 = new Font("隶书",Font.PLAIN,50);
		label1.setFont(f1);
		label1.setForeground(Color.red);
		label1.setVerticalTextPosition(JLabel.TOP);
		//label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setBounds(180, 0, 526, 50);
		panel.add(label1);		
		JLabel label2 = new JLabel(str);
		Font f2 = new Font("隶书",Font.PLAIN,30);
		label2.setFont(f2);
		label2.setVerticalTextPosition(JLabel.TOP);
		label2.setForeground(Color.black);
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setBounds(80, 0, 440, 400);
		
/*		JLabel pic[]=new JLabel[num];
		int h = 70;
		for(int i = 0; i < num; i++) {
			
			pic[i].setBounds(100,550,resultImage[i].getIconWidth(),resultImage[i].getIconHeight());
			h+=30;
		}*/
		//I tried to add a picture of dice points to everyone's results, but I failed
		
		panel.add(label2);
		jf.add(panel);
		jf.setVisible(true);//frame
	}//shake
	public String[] Statistics(int dice[][],int ln) {
		int d[][] = new int[ln][6];
		for(int i = 0; i < ln; i++) {
			for(int  j = 0; j < 6; j++) {
				int n = dice[i][j] - 1;
				d[i][n]++;//player x 有几个n点
			}
		}
		String[] result = new String[ln];
		result = judge(d,result);
		return result;
	}
	public String[] judge(int di[][],String result[]) {
		int ln = result.length;
		for(int i = 0; i < ln; i++) {
			if(di[i][3] == 4 && di[i][0] == 2) {
				result[i] = "状元插金花";
			}else if(di[i][3] == 6) {
				result[i] = "状元·六杯红";
			}else if(di[i][5] == 6) {
				result[i] = "状元·六杯黑";
			}else if(di[i][3] == 5) {
				result[i] = "状元·五王";
			}else if(di[i][2] == 5 && di[i][3] == 1) {
				result[i] = "状元·五子带一秀";
			}else if(di[i][2] == 5 && di[i][3] != 1) {
				result[i] = "状元·五子登科";
			}else if(di[i][3] == 4 && di[i][0] != 2) {
				result[i] = "状元·五子带一秀";
			}else if(di[i][3] == 4) {
				result[i] = "状元";
			}else if(di[i][0] == 1 && di[i][1] == 1 && di[i][2] == 1 && di[i][3] == 1 && di[i][4] == 1 && di[i][5] == 1) {
				result[i] = "榜眼·对堂";
			}else if(di[i][3] == 3) {
				result[i] = "探花·三红";
			}else if(di[i][1] == 4) {
				result[i] = "进士·四进";
			}else if(di[i][3] == 2) {
				result[i] = "举人·二举";
			}else if(di[i][3] == 1 && di[i][2] != 5) {
				result[i] = "秀才·一秀";
			}else {
				result[i] = "未中";
			}
		}//result of everyone
		return result;
	}

	private void placeComponents(JPanel panel,int num, String[] name, JFrame jf) {

	    panel.setLayout(null);
	    
	    JButton resetButton = new JButton("重来");
	    resetButton.setBounds(150, 325, 60, 40);
	    panel.add(resetButton);
	    resetButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            jf.dispose();
	        }
	    });
	    resetButton.addActionListener(this);
	    
	    // 创建 JLabel
	    JButton nextButton = new JButton("再来一轮");
	    nextButton.setBounds(300, 325, 110, 40);
	    panel.add(nextButton);
	    nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shake(num, name);
            }
        });
	    nextButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            jf.dispose();
	        }
	    });
	    /* 
	     * setBounds(x, y, width, height)
	     * x 和 y 指定"""左上角"""的新位置，由 width 和 height 指定新的大小。
	     */
	    JButton BHelp = new JButton("Help");
		BHelp.setBounds(460, 0, 60, 25);//(526, 708)
		panel.add(BHelp);
		BHelp.addActionListener(new Help());
		ImageIcon god=new ImageIcon("D:\\BOBING-IMAGE\\财神small.PNG");//Background picture (must be placed at the end)
	    JLabel pic1=new JLabel(god);
	    pic1.setBounds(5,550,god.getIconWidth(),god.getIconHeight());
	    panel.add(pic1);
	    ImageIcon bowl=new ImageIcon("D:\\BOBING-IMAGE\\博饼碗.PNG");//Background picture (must be placed at the end)
	    JLabel pic2=new JLabel(bowl);
	    pic2.setOpaque(false);
	    pic2.setBounds(90,380,bowl.getIconWidth(),bowl.getIconHeight());
	    panel.add(pic2);//Background picture (must be placed at the end)
	}
}

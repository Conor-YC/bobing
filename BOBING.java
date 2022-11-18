import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
/*8Bobing beta1.23.0
 * Made by Yuke Chen*/

public class BOBING {
public static void main(String[] args) {
	
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame jf = new JFrame("Bobing");
	jf.setSize(526, 708);
	jf.setResizable(false);
	jf.setLocationRelativeTo(null);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	playMusic();//bgm
	
	JPanel panel = new JPanel(); 
	
	jf.add(panel);
	placeComponents(panel, jf);
	
	//jf.getContentPane().setBackground(new Color(0, 0, 0));	
	jf.setVisible(true);//frame
}//main

static Clip clip;
public static void playMusic() {
    try
    {
        File musicPath = new File("D:\\软件素材\\中国国家交响乐团 - 丰收.wav");//here is bgm(.wav)

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);//设置音量，范围为 -60.0f 到 6.0f
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else{}
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
}
private static void placeComponents(JPanel panel, JFrame jf) {

    panel.setLayout(null);
    
/*    JLabel label0 = new JLabel("<html><body>Bobing beta1.23.0<br>Made by Yuke Chen<body></html>",Label.RIGHT);
	Font f0 = new Font("隶书",Font.PLAIN,15);
	label0.setFont(f0);
	label0.setForeground(Color.white);
	label0.setBounds(400, 670, 100, 40);
	panel.add(label0);*/
	
    ImageIcon play = new ImageIcon("D:\\BOBING-IMAGE\\开始.PNG");
    JButton playButton = new JButton(play);
    playButton.setBounds(165, 275, 196, 101);
    panel.add(playButton);
    playButton.addActionListener(new play());
    playButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jf.dispose();
        }
    });
    
    // 创建 JLabel
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
    pic2.setBounds(90,380,bowl.getIconWidth(),bowl.getIconHeight());
    pic2.setOpaque(false);
    panel.add(pic2);//Background picture (must be placed at the end)
    
    
	
	ImageIcon moon=new ImageIcon("D:\\BOBING-IMAGE\\moon.PNG");//Background picture (must be placed at the end)
    JLabel pic3=new JLabel(moon);
    pic3.setBounds(0,0,moon.getIconWidth(),moon.getIconHeight());
    panel.add(pic3);//Background picture (must be placed at the end)
	
}
}

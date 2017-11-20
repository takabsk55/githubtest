import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JFrame implements ActionListener{
	static Frame frame=new Frame("ラブマゲドン");
	JPanel group = new JPanel();
	Human manResult[]=new Human[6];
	Human womanResult[]=new Human[6];
	
	public static void main(String args[]){




	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	GraphicsDevice device= GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	device.setFullScreenWindow(frame);
	frame.setVisible(true);
	}
	public Frame(String title) {
		// TODO 自動生成されたコンストラクター・スタブ
		setTitle(title);


		group.setLayout(null);

		JButton manButton1=new JButton();
		JButton manButton2=new JButton();
		JButton manButton3=new JButton();
		JButton manButton4=new JButton();
		JButton manButton5=new JButton();

		JButton womanButton1=new JButton();
		JButton womanButton2=new JButton();
		JButton womanButton3=new JButton();
		JButton womanButton4=new JButton();
		JButton womanButton5=new JButton();

		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=screenSize.width;
		int h=screenSize.height;

		manButton1.setText("TAKAHIRO");
		manButton1.setBounds(w-120,0,100,50);
		manButton1.addActionListener(this);
		manButton1.setActionCommand("man1");
		group.add(manButton1);


		manButton2.setText("おおき");
		manButton2.setBounds(w-120,(h-100)/4,100,50);
		manButton2.addActionListener(this);
		manButton2.setActionCommand("man2");
		group.add(manButton2);

		manButton3.setText("うっちー");
		manButton3.setBounds(w-120, (h-100)/4*2,100,50);
		manButton3.addActionListener(this);
		manButton3.setActionCommand("man3");
		group.add(manButton3);

		manButton4.setText("すなちゃん");
		manButton4.setBounds(w-120,(h-100)/4*3,100,50);
		manButton4.addActionListener(this);
		manButton4.setActionCommand("man4");
		group.add(manButton4);

		manButton5.setText("わったん");
		manButton5.setBounds(w-120,h-100,100,50);
		manButton5.addActionListener(this);
		manButton5.setActionCommand("man5");
		group.add(manButton5);


		womanButton1.setText("める");
		womanButton1.setBounds(0,0,100,50);
		womanButton1.addActionListener(this);
		womanButton1.setActionCommand("woman1");
		group.add(womanButton1);

		womanButton2.setText("めありー");
		womanButton2.setBounds(0,(h-100)/4,100,50);
		womanButton2.addActionListener(this);
		womanButton2.setActionCommand("woman2");
		group.add(womanButton2);

		womanButton3.setText("みーすけ");
		womanButton3.setBounds(0, (h-100)/4*2,100,50);
		womanButton3.addActionListener(this);
		womanButton3.setActionCommand("woman3");
		group.add(womanButton3);
		womanButton4.setText("りの");
		womanButton4.setBounds(0,(h-100)/4*3,100,50);
		womanButton4.addActionListener(this);
		womanButton4.setActionCommand("woman4");
		group.add(womanButton4);

		womanButton5.setText("かなっぺ");
		womanButton5.setBounds(0,h-100,100,50);
		womanButton5.addActionListener(this);
		womanButton5.setActionCommand("woman5");
		group.add(womanButton5);

		getContentPane().add(group,BorderLayout.CENTER);




		Human man1=new Human();
		Human man2=new Human();
		Human man3=new Human();
		Human man4=new Human();
		Human man5=new Human();

		Human woman1=new Human();
		Human woman2=new Human();
		Human woman3=new Human();
		Human woman4=new Human();
		Human woman5=new Human();


		manResult[1]=man1;
		manResult[2]=man2;
		manResult[3]=man3;
		manResult[4]=man4;
		manResult[5]=man5;

		womanResult[1]=woman1;
		womanResult[2]=woman2;
		womanResult[3]=woman3;
		womanResult[4]=woman4;
		womanResult[5]=woman5;


		try{
			//ファイルを読み込む
			FileReader fr= new FileReader("result.csv");
			BufferedReader br=new BufferedReader(fr);

			//読み込んだファイルを1行ずつ処理する
			String line;
			StringTokenizer token;
			line=br.readLine();
			while((line=br.readLine())!=null){
				token=new StringTokenizer(line,"\",\"");
				token.nextToken();
				if(token.nextToken().equals("男性")){
					int manNumber=Integer.parseInt(token.nextToken());
					manResult[manNumber].setSex(1);
					manResult[manNumber].setToLove(Integer.parseInt(token.nextToken()));

				}else{
					int womanNumber=Integer.parseInt(token.nextToken());
					womanResult[womanNumber].setSex(2);
					womanResult[womanNumber].setToLove(Integer.parseInt(token.nextToken()));
				}
			}
			br.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}

	}
	int f=0;

	public void actionPerformed(ActionEvent e){
		BufferedImage hart=null;
		BufferedImage hartbreak=null;

		try{
			hart=ImageIO.read(new File("../LoveMagedon/src/hart.jpg"));
		}catch(Exception e1){
			e1.printStackTrace();
		}
		try{
			hartbreak=ImageIO.read(new File("../LoveMagedon/src/heart_break.png"));
		}catch(Exception e2){
			e2.printStackTrace();
		}

		String cmd =e.getActionCommand();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=screenSize.width;
		int h=screenSize.height;
		Graphics g = null;
		g=getGraphics();


		//man1 is clicked
		if(cmd.equals("man1")){
			if(f==1){
				repaint();
				f=0;
			}
			else{

				try {
					//(h-105)/4
					int target=0;
					target=manResult[1].getToLove();
					g.drawLine((w-115)-(w-220)/5,65+((h-105)/4*(target-1))/5,(w-115), 65);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*2,65+((h-105)/4*(target-1))/5*2,(w-115), 65);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*3,65+((h-105)/4*(target-1))/5*3,(w-115), 65);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*4,65+((h-105)/4*(target-1))/5*4,(w-115), 65);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*5,65+((h-105)/4*(target-1))/5*5,(w-115), 65);
					Thread.sleep(2000);
					if(womanResult[target].getToLove()==1){
						g.drawImage(hart, w/2-250,h/2-250,this);
					}else{
						g.drawImage(hartbreak, w/2-300, h/2-300, this);
					}
				} catch (InterruptedException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

				f=1;
			}
		}

		//man2 is clicked
		if(cmd.equals("man2")){
			if(f==1){
				repaint();
				f=0;
			}
			else{

				try {
					//(h-105)/4
					int target=0;
					target=manResult[2].getToLove();
					System.out.println(target);

					int targetHigh=65+((h-105)/4*(target-1));


					g.drawLine((w-115)-(w-220)/5,targetHigh+(65+(h-105)/4-targetHigh)/5*4,(w-115), 65+(h-105)/4);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4-targetHigh)/5*3,(w-115)-(w-220)/5,targetHigh+(65+(h-105)/4-targetHigh)/5*4);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4-targetHigh)/5*2,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4-targetHigh)/5*3);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4-targetHigh)/5*1,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4-targetHigh)/5*2);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*5,targetHigh,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4-targetHigh)/5*1);
					Thread.sleep(2000);
					if(womanResult[target].getToLove()==2){
						g.drawImage(hart, w/2-250,h/2-250,this);
					}else{
						g.drawImage(hartbreak, w/2-300, h/2-300, this);
					}
				} catch (InterruptedException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

				f=1;
			}
		}
		//man3 is clicked
		if(cmd.equals("man3")){
			if(f==1){
				repaint();
				f=0;
			}
			else{

				try {
					//(h-105)/4
					int target=0;
					target=manResult[3].getToLove();
					int targetHigh=65+((h-105)/4*(target-1));


					g.drawLine((w-115)-(w-220)/5,targetHigh+(65+(h-105)/4*2-targetHigh)/5*4,(w-115), 65+(h-105)/4*2);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*2-targetHigh)/5*3,(w-115)-(w-220)/5,targetHigh+(65+(h-105)/4*2-targetHigh)/5*4);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*2-targetHigh)/5*2,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*2-targetHigh)/5*3);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*2-targetHigh)/5*1,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*2-targetHigh)/5*2);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*5,targetHigh,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*2-targetHigh)/5*1);
					Thread.sleep(2000);
					if(womanResult[target].getToLove()==3){
						g.drawImage(hart, w/2-250,h/2-250,this);
					}else{
						g.drawImage(hartbreak, w/2-300, h/2-300, this);
					}
				} catch (InterruptedException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

				f=1;
			}
		}

		//man4 is clicked
		if(cmd.equals("man4")){
			if(f==1){
				repaint();
				f=0;
			}
			else{

				try {
					//(h-105)/4
					int target=0;
					target=manResult[4].getToLove();

					int targetHigh=65+((h-105)/4*(target-1));

					g.drawLine((w-115)-(w-220)/5,targetHigh+(65+(h-105)/4*3-targetHigh)/5*4,(w-115), 65+(h-105)/4*3);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*3-targetHigh)/5*3,(w-115)-(w-220)/5,targetHigh+(65+(h-105)/4*3-targetHigh)/5*4);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*3-targetHigh)/5*2,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*3-targetHigh)/5*3);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*3-targetHigh)/5*1,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*3-targetHigh)/5*2);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*5,targetHigh,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*3-targetHigh)/5*1);
					Thread.sleep(2000);
					if(womanResult[target].getToLove()==4){
						g.drawImage(hart, w/2-250,h/2-250,this);
					}else{
						g.drawImage(hartbreak, w/2-300, h/2-300, this);
					}
				} catch (InterruptedException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

				f=1;
			}
		}

		//man5 is clicked
		if(cmd.equals("man5")){
			if(f==1){
				repaint();
				f=0;
			}
			else{

				try {
					//(h-105)/4
					int target=0;
					target=manResult[5].getToLove();
					int targetHigh=65+((h-105)/4*(target-1));

					g.drawLine((w-115)-(w-220)/5,targetHigh+(65+(h-105)/4*4-targetHigh)/5*4,(w-115), 65+(h-105)/4*4);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*4-targetHigh)/5*3,(w-115)-(w-220)/5,targetHigh+(65+(h-105)/4*4-targetHigh)/5*4);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*4-targetHigh)/5*2,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*4-targetHigh)/5*3);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*4-targetHigh)/5*1,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*4-targetHigh)/5*2);
					Thread.sleep(1000);
					g.drawLine((w-115)-(w-220)/5*5,targetHigh,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*4-targetHigh)/5*1);
					Thread.sleep(2000);
					if(womanResult[target].getToLove()==5){
						g.drawImage(hart, w/2-250,h/2-250,this);
					}else{
						g.drawImage(hartbreak, w/2-300, h/2-300, this);
					}
				} catch (InterruptedException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

				f=1;
			}
		}
		//woman1 is clicked
				if(cmd.equals("woman1")){
					if(f==1){
						repaint();
						f=0;
					}
					else{

						try {
							//(h-105)/4
							int target=0;
							target=womanResult[1].getToLove();

							int targetHigh=65+((h-105)/4*(target-1));
							g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*0-targetHigh)/5*4,105, 65+(h-105)/4*0);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*0-targetHigh)/5*3,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*0-targetHigh)/5*4);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*0-targetHigh)/5*2,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*0-targetHigh)/5*3);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*0-targetHigh)/5*1,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*0-targetHigh)/5*2);
							Thread.sleep(1000);
							g.drawLine(w-115,targetHigh,(w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*0-targetHigh)/5*1);
							Thread.sleep(2000);

							if(manResult[target].getToLove()==1){
								g.drawImage(hart, w/2-250,h/2-250,this);
							}else{
								g.drawImage(hartbreak, w/2-300, h/2-300, this);
							}
						} catch (InterruptedException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}

						f=1;
					}
				}

				//woman2 is clicked
				if(cmd.equals("woman2")){
					if(f==1){
						repaint();
						f=0;
					}
					else{

						try {
							//(h-105)/4
							int target=0;
							target=womanResult[2].getToLove();

							int targetHigh=65+((h-105)/4*(target-1));
							g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*1-targetHigh)/5*4,105, 65+(h-105)/4*1);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*1-targetHigh)/5*3,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*1-targetHigh)/5*4);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*1-targetHigh)/5*2,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*1-targetHigh)/5*3);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*1-targetHigh)/5*1,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*1-targetHigh)/5*2);
							Thread.sleep(1000);
							g.drawLine(w-115,targetHigh,(w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*1-targetHigh)/5*1);
							Thread.sleep(2000);

							if(manResult[target].getToLove()==2){
								g.drawImage(hart, w/2-250,h/2-250,this);
							}else{
								g.drawImage(hartbreak, w/2-300, h/2-300, this);
							}
						} catch (InterruptedException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}

						f=1;
					}
				}

				//woman3 is clicked
				if(cmd.equals("woman3")){
					if(f==1){
						repaint();
						f=0;
					}
					else{

						try {
							//(h-105)/4
							int target=0;
							target=womanResult[3].getToLove();

							int targetHigh=65+((h-105)/4*(target-1));
							g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*2-targetHigh)/5*4,105, 65+(h-105)/4*2);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*2-targetHigh)/5*3,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*2-targetHigh)/5*4);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*2-targetHigh)/5*2,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*2-targetHigh)/5*3);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*2-targetHigh)/5*1,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*2-targetHigh)/5*2);
							Thread.sleep(1000);
							g.drawLine(w-115,targetHigh,(w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*2-targetHigh)/5*1);
							Thread.sleep(2000);

							if(manResult[target].getToLove()==3){
								g.drawImage(hart, w/2-250,h/2-250,this);
							}else{
								g.drawImage(hartbreak, w/2-300, h/2-300, this);
							}
						} catch (InterruptedException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}

						f=1;
					}
				}

				//woman4 is clicked
				if(cmd.equals("woman4")){
					if(f==1){
						repaint();
						f=0;
					}
					else{

						try {
							//(h-105)/4
							int target=0;
							target=womanResult[4].getToLove();

							int targetHigh=65+((h-105)/4*(target-1));
							g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*3-targetHigh)/5*4,105, 65+(h-105)/4*3);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*3-targetHigh)/5*3,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*3-targetHigh)/5*4);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*3-targetHigh)/5*2,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*3-targetHigh)/5*3);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*3-targetHigh)/5*1,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*3-targetHigh)/5*2);
							Thread.sleep(1000);
							g.drawLine(w-115,targetHigh,(w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*3-targetHigh)/5*1);
							Thread.sleep(2000);

							if(manResult[target].getToLove()==4){
								g.drawImage(hart, w/2-250,h/2-250,this);
							}else{
								g.drawImage(hartbreak, w/2-300, h/2-300, this);
							}
						} catch (InterruptedException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}

						f=1;
					}
				}

				//woman5 is clicked
				if(cmd.equals("woman5")){
					if(f==1){
						repaint();
						f=0;
					}
					else{

						try {
							//(h-105)/4
							int target=0;
							target=womanResult[5].getToLove();

							int targetHigh=65+((h-105)/4*(target-1));
							g.drawLine((w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*4-targetHigh)/5*4,105, 65+(h-105)/4*4);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*4-targetHigh)/5*3,(w-115)-(w-220)/5*4,targetHigh+(65+(h-105)/4*4-targetHigh)/5*4);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*4-targetHigh)/5*2,(w-115)-(w-220)/5*3,targetHigh+(65+(h-105)/4*4-targetHigh)/5*3);
							Thread.sleep(1000);
							g.drawLine((w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*4-targetHigh)/5*1,(w-115)-(w-220)/5*2,targetHigh+(65+(h-105)/4*4-targetHigh)/5*2);
							Thread.sleep(1000);
							g.drawLine(w-115,targetHigh,(w-115)-(w-220)/5*1,targetHigh+(65+(h-105)/4*4-targetHigh)/5*1);
							Thread.sleep(2000);

							if(manResult[target].getToLove()==5){
								g.drawImage(hart, w/2-250,h/2-250,this);
							}else{
								g.drawImage(hartbreak, w/2-300, h/2-300, this);
							}
						} catch (InterruptedException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}

						f=1;
					}
				}


	}

}

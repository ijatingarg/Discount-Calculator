import javax.swing.*;
//import javax.swing.Jlabel;
import java.awt.*;
import java.awt.event.*;


public class DiscountCalculator extends Frame 
{
	JLabel itcode,price,dis,netamount,category;
	JTextField textcode,textprice,textdis,textamount;
	JButton calculate,refresh;
	JCheckBox member;
	JRadioButton men,women,kids;
	double p,result;
	ButtonGroup bg;
	Icon img,img1;
	JFrame frame = new JFrame();
	public DiscountCalculator(){

		itcode = new JLabel("Itcode",JLabel.LEFT);
		price = new JLabel("Price",JLabel.LEFT);
		dis = new JLabel("Discount",JLabel.RIGHT);
		netamount = new JLabel("Net Amount",JLabel.RIGHT);
		category = new JLabel("Category");

		textcode = new JTextField();
		textprice = new JTextField();
		textdis = new JTextField();
		textamount = new JTextField();

		member = new JCheckBox("Membership Card Holder");
		member.setBackground(Color.white);

		img = new ImageIcon("cal.png");
		calculate = new JButton(img);
		img1 = new ImageIcon("r.png");
		refresh = new JButton(img1);

		men = new JRadioButton("Men");
		women = new JRadioButton("Women");
		kids = new JRadioButton("Kids");

		bg = new ButtonGroup();

		itcode.setBounds(60,50,60,40);
		price.setBounds(60,100,60,40);
		dis.setBounds(300,50,80,40);
		dis.setVisible(false);
		netamount.setBounds(300,100,80,40);
		netamount.setVisible(false);
		category.setBounds(60,200,80,20);

		textcode.setBounds(110,50,100,40);
		textprice.setBounds(110,100,100,40);
		textdis.setBounds(400,50,100,40);
		textdis.setVisible(false);
		textamount.setBounds(400,100,100,40);
		textamount.setVisible(false);
		member.setBounds(300,200,200,30);

		men.setBounds(60,250,80,30);
		women.setBounds(60,300,80,30);
		kids.setBounds(60,350,80,30);

		calculate.setBounds(300,270,120,40);
		refresh.setBounds(300,340,120,60);

		
		men.setBackground(Color.white);
		women.setBackground(Color.white);
		kids.setBackground(Color.white);
		calculate.setBackground(Color.white);
		refresh.setBackground(Color.white);
		calculate.setBorderPainted(false);
		refresh.setBorderPainted(false);


		//men.setFont(new Font("",Font.BOLD,15));

		add(itcode);
		add(price);
		add(dis);
		add(netamount);
		add(category);
		add(textcode);
		add(textprice);
		add(textdis);
		add(textamount);
		add(member);
		add(men);
		add(women);
		add(kids);
		add(calculate);
		add(refresh);
		bg.add(men);
		bg.add(women);
		bg.add(kids);
		
		setLayout(null);
  		setTitle("Discount Calculator");
    	setSize(600,600);                      
    	setVisible(true);
    	

  
  		calculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(men.isSelected())
				{

					p = Integer.parseInt(textprice.getText());
					result = p-((20*p)/100);
					textamount.setText(result+" Rs.");
					textdis.setText("20%");
				}

				else if(women.isSelected())
				{
					p = Integer.parseInt(textprice.getText());
					result = p-((12*p)/100);
					textamount.setText(result+" Rs.");
					textdis.setText("12%");
				}
						
				else if(kids.isSelected())
				{
					p = Integer.parseInt(textprice.getText());
					result = p-((8*p)/100);
					textamount.setText(result+" Rs.");
					textdis.setText("8%");	
				}

				if(member.isSelected()&&men.isSelected())
				{
					p = Integer.parseInt(textprice.getText());
					result = p-((25*p)/100);
					textamount.setText(result+" Rs.");
					textdis.setText("25%");	
				}
				else if(women.isSelected()&&member.isSelected())
				{
					p = Integer.parseInt(textprice.getText());
					result = p-((17*p)/100);
					textamount.setText(result+" Rs.");
					textdis.setText("17%");
				}
						
				else if(kids.isSelected()&&member.isSelected())
				{
					p = Integer.parseInt(textprice.getText());
					result = p-((13*p)/100);
					textamount.setText(result+" Rs.");
					textdis.setText("13%");	
				}
						
				textamount.setVisible(true);
				textdis.setVisible(true);
				netamount.setVisible(true);
				dis.setVisible(true);
			}
		});

		refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				textamount.setVisible(false);
				textdis.setVisible(false);
				netamount.setVisible(false);
				dis.setVisible(false);

				textprice.setText("");
				textcode.setText("");

				member.setSelected(false);
				men.setSelected(false);
				women.setSelected(false);
				kids.setSelected(false);

				//bg.setSelected(bg.setSelection(), false);
			}
		});

	}

	
	public static void main(String[] args) {
		new DiscountCalculator();
		
	}
}

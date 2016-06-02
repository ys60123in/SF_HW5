import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SF_HW5 extends JFrame {
	private JTextField TF_Child;
	private JTextField TF_Adult;
	private JComboBox CB_Time;
	private JTextArea TA_Receipt;
	private int adultNum, childNum, total;
	
	public void PrintReceipt(){
		if("".equals(TF_Adult.getText())||"".equals(TF_Child.getText())) return;
		
		adultNum = Integer.parseInt(TF_Adult.getText());
		childNum = Integer.parseInt(TF_Child.getText());
		int all = adultNum + childNum
				,freeNum = all/3
				,count = freeNum
				,childTmp = childNum
				,adultTmp = adultNum;
		
		
		TA_Receipt.append("時段："+CB_Time.getSelectedItem()+"\n");
		TA_Receipt.append("大人"+adultNum+"人\n小孩"+childNum+"人\n總計"+all+"人\n================\n");
		//-------------------------
		if(CB_Time.getSelectedIndex()==0){
			total = adultNum * 295 + childNum * 132;
			TA_Receipt.append("需付金額："+total+"元(未打折前)\n");
			if(freeNum>=1){
				while(childTmp!=0 && count!=0){
					total = total - 132;
					childTmp--;
					count--;
				}
				while(adultTmp!=0 && count!=0){
					total = total - 295;
					adultTmp--;
					count--;
				}
				TA_Receipt.append("需付金額："+total+"元(促銷優惠後)\n");
			}else{
				TA_Receipt.append("需付金額："+total+"元(無促銷優惠)\n");
			}
			
		}else{
			total = adultNum * 405 + childNum * 165;
			TA_Receipt.append("需付金額："+total+"元(未打折前)\n");
			
			if(freeNum>=1){
				while(childTmp!=0 && count!=0){
					total = total - 165;
					childTmp--;
					count--;
				}
				while(adultTmp!=0 && count!=0){
					total = total - 405;
					adultTmp--;
					count--;
				}
				TA_Receipt.append("需付金額："+total+"元(促銷優惠後)\n");
			}else{
				TA_Receipt.append("需付金額："+total+"元(無促銷優惠)\n");
			}
		}
		//--------------------------
		if(all > 10){
			TA_Receipt.append("最後需付金額："+(int)(total*0.95)+"元(超過10人優惠)");
		}else{
			TA_Receipt.append("最後需付金額："+total+"元(無超過10人優惠)");
		}
		
	}
	
	SF_HW5(){
		setTitle("日式餐廳發票列印程式");
		
		//設定視窗預設的關閉動作、視窗大小, 並顯示視窗
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(630, 230);
		getContentPane().setLayout(null);
		
		JLabel LB_Time = new JLabel("\u9078\u64C7\u6642\u6BB5\uFF1A");
		LB_Time.setFont(new Font("新細明體", Font.PLAIN, 16));
		LB_Time.setBounds(10, 20, 90, 25);
		getContentPane().add(LB_Time);
		
		CB_Time = new JComboBox();
		CB_Time.setModel(new DefaultComboBoxModel(new String[] {"\u5E73\u65E5\u4E2D\u5348", "\u5E73\u65E5\u665A\u4E0A\u6216\u4F8B\u5047\u65E5"}));
		CB_Time.setFont(new Font("新細明體", Font.PLAIN, 16));
		CB_Time.setBounds(100, 20, 200, 25);
		getContentPane().add(CB_Time);
		
		JLabel LB_Adult = new JLabel("\u5927\u4EBA\u4EBA\u6578\uFF1A");
		LB_Adult.setFont(new Font("新細明體", Font.PLAIN, 16));
		LB_Adult.setBounds(10, 60, 90, 25);
		getContentPane().add(LB_Adult);
		
		TF_Adult = new JTextField();
		TF_Adult.setFont(new Font("新細明體", Font.PLAIN, 16));
		TF_Adult.setBounds(100, 60, 200, 25);
		getContentPane().add(TF_Adult);
		TF_Adult.setColumns(10);
		
		JLabel LB_Child = new JLabel("\u5C0F\u5B69\u4EBA\u6578\uFF1A");
		LB_Child.setFont(new Font("新細明體", Font.PLAIN, 16));
		LB_Child.setBounds(10, 100, 90, 25);
		getContentPane().add(LB_Child);
		
		TF_Child = new JTextField();
		TF_Child.setFont(new Font("新細明體", Font.PLAIN, 16));
		TF_Child.setBounds(100, 100, 200, 25);
		getContentPane().add(TF_Child);
		TF_Child.setColumns(10);
		
		JButton BTN_PrintReceipt = new JButton("\u5370    \u51FA    \u767C    \u7968");
		BTN_PrintReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TA_Receipt.setText(null);
				PrintReceipt();			
			}
		});
		BTN_PrintReceipt.setFont(new Font("新細明體", Font.PLAIN, 16));
		BTN_PrintReceipt.setBounds(10, 150, 290, 30);
		getContentPane().add(BTN_PrintReceipt);
		
		TA_Receipt = new JTextArea();
		TA_Receipt.setEditable(false);
		TA_Receipt.setFont(new Font("Monospaced", Font.PLAIN, 12));
		TA_Receipt.setBounds(310, 20, 295, 160);
		getContentPane().add(TA_Receipt);
		setVisible(true);
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SF_HW5();
	}
}

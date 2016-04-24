import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameFrame {
	Console console = new Console();
	
	private JFrame gameFrame;
	private int frameWidth = 1400;
	private int frameHeight = 1000;
	
	private JPanel gameArea;
	private Image image = new ImageIcon("background.jpg").getImage();  
	private int areaWidth = 1000;
	private int areaHeight = 1000;
	private int spaceSide = 20;
	private int[][] map;
	
	private int[] objects;
	
	private JPanel menu;
	private JLabel lName;
	private JLabel lPrice;
	private JLabel lMCost;
	private JLabel lCapacity;
	private JLabel lDuration;
	private JLabel lRange;
	
	private Vector<GameObject> objectMap = new Vector<GameObject>();
	private Vector<GameObject> allObjects = new Vector<GameObject>();
	private GameObject wall;
	private GameObject energy;
	private GameObject oxygen;
	private GameObject water;
	private GameObject food;
	
	private JPanel menuPanel;
	private int menuPanelWidth = 400;
	private int menuPanelHeight = 1000;
	private spaceButton btn1 = new spaceButton("Wall");
	private spaceButton btn2 = new spaceButton("Energy");
	private spaceButton btn3 = new spaceButton("Oxygen");
	private spaceButton btn4 = new spaceButton("Water");
	private spaceButton btn5 = new spaceButton("Food");
	
	private boolean mouseIsHoldingSth = false;
	private JPanel mouseObj;
	private Point mouseObjSize;
	private int holdingItemID;
	private GameObject holdingItem;
	private GameObject puttingObj;
	
	gameFrame() {
		gameFrame = new JFrame();
		gameFrame.setBounds(0, 0, frameWidth, frameHeight);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
		gameFrame.setLayout(null);
		gameFrame.setVisible(true);
		
		gameArea = new backgroundPanel();
		gameArea.setBounds(0, 0, areaWidth, areaHeight);
		gameArea.setLayout(null);
		gameArea.setBackground(Color.white);
		gameFrame.add(gameArea);
		
		menu = new JPanel();
		menu.setSize(400, 400);
		menu.setLocation(1000, 400);
		menu.setLayout(null);
		menu.setBackground(Color.lightGray);
		gameFrame.add(menu);
		
		lName = new JLabel();
		lName.setText("Name");
		lName.setSize(300, 50);
		lName.setLocation(10, 10);
		menu.add(lName);
		
		lPrice = new JLabel();
		lPrice.setSize(300, 50);
		lPrice.setLocation(10, 70);
		lPrice.setText("Price");
		menu.add(lPrice);
		
		lMCost = new JLabel();
		lMCost.setSize(300, 50);
		lMCost.setLocation(10, 130);
		lMCost.setText("lMCost");
		menu.add(lMCost);
		
		lCapacity = new JLabel();
		lCapacity.setSize(300, 50);
		lCapacity.setLocation(10, 200);
		lCapacity.setText("lCapacity");
		menu.add(lCapacity);

		lDuration = new JLabel();
		lDuration.setSize(300, 50);
		lDuration.setLocation(10, 260);
		lDuration.setText("lDuration");
		menu.add(lDuration);

		lRange = new JLabel();
		lRange.setSize(300, 50);
		lRange.setLocation(10, 320);
		lRange.setText("lRange");
		menu.add(lRange);

		
		objects = new int[5];
		for (int i = 0; i < 5; i++) {
			objects[i] = 0;
		}
		
		menuPanel = new JPanel();
		gameFrame.add(menuPanel);
		menuPanel.setLocation(1100, 0);
		menuPanel.setSize(menuPanelWidth, menuPanelHeight);
		menuPanel.setLayout(null);
		menuPanel.add(btn1);
		menuPanel.add(btn2);
		menuPanel.add(btn3);
		menuPanel.add(btn4);
		menuPanel.add(btn5);
		btn1.setLocation(10, 10);
		btn2.setLocation(10, 70);
		btn3.setLocation(10, 130);
		btn4.setLocation(10, 190);
		btn5.setLocation(10, 250);
		btn1.setID(1);
		btn2.setID(2);
		btn3.setID(3);
		btn4.setID(4);
		btn5.setID(5);
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mouseObjSize = new Point(wall.getSpaceSize());
				holdingItemID = wall.getID();
				generateMouseObj(mouseObjSize.x, mouseObjSize.y);
				mouseObj.setVisible(true);
				mouseIsHoldingSth = true;
			}
		});
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mouseObjSize = new Point(energy.getSpaceSize());
				holdingItemID = energy.getID();
				generateMouseObj(mouseObjSize.x, mouseObjSize.y);
				mouseObj.setVisible(true);
				mouseIsHoldingSth = true;
			}
		});
		btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mouseObjSize = new Point(oxygen.getSpaceSize());
				holdingItemID = oxygen.getID();
				generateMouseObj(mouseObjSize.x, mouseObjSize.y);
				mouseObj.setVisible(true);
				mouseIsHoldingSth = true;
			}
		});
		btn4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mouseObjSize = new Point(water.getSpaceSize());
				holdingItemID = water.getID();
				generateMouseObj(mouseObjSize.x, mouseObjSize.y);
				mouseObj.setVisible(true);
				mouseIsHoldingSth = true;
			}
		});
		btn5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mouseObjSize = new Point(food.getSpaceSize());
				holdingItemID = food.getID();
				generateMouseObj(mouseObjSize.x, mouseObjSize.y);
				mouseObj.setVisible(true);
				mouseIsHoldingSth = true;
			}
		});
		
		
		
		int numx = areaWidth / spaceSide;
		int numy = areaHeight / spaceSide;
		map = new int[numx][numy];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = 0;
			}
		}
		
		wall = new GameObject("wall.png");
		wall.setSize(20, 20);
		wall.setBackground(Color.black);
		wall.setLocation(0, 0);
		wall.setID(1);
		wall.setSpaceSize(1, 1);
//		wall.setImage("wall.png");

		
		energy = new GameObject("energy.png");
		energy.setImage("energy.png");
		energy.setSize(20, 40);
		energy.setBackground(Color.yellow);
		energy.setLocation(-500, -500);
		energy.setID(2);
		energy.setSpaceSize(1, 2);
		
		
//		energy.setImage("energy.png");
		//
		oxygen = new GameObject("oxygen.png");
		oxygen.setSize(40, 40);
		oxygen.setBackground(Color.red);
		oxygen.setLocation(0, 0);
		oxygen.setID(3);
		oxygen.setSpaceSize(2, 2);
//		oxygen.setImage("oxygen.png");
		//
		water = new GameObject("water.png");
		water.setSize(60, 60);
		water.setBackground(Color.blue);
		water.setLocation(0, 0);
		water.setID(4);
		water.setSpaceSize(3, 3);
//		water.setImage("water.png");
		//
		food = new GameObject();
		food.setSize(40, 80);
		food.setBackground(Color.green);
		food.setLocation(0, 0);
		food.setID(5);
		food.setSpaceSize(2, 4);
		food.setImage("food.png");

		
		
		
		objectMap.add(wall);
		objectMap.add(energy);
		objectMap.add(oxygen);
		objectMap.add(water);
		objectMap.add(food);
	
		gameArea.addMouseListener(new mapMouseListener());
		gameArea.addMouseMotionListener(new mapMouseMotionListener());
	}
	
	public void putObjectOn(GameObject obj, Point p) {
		System.out.println(obj.getClass());
		GameObject temp = new GameObject();
		temp.copyFromGameObject(obj);
		gameArea.add(temp);
		temp.setLocation(p.x * spaceSide, p.y * spaceSide);
		allObjects.add(temp);
		signObjects();
		int dx = obj.getSpaceSize().x;
		int dy = obj.getSpaceSize().y;
		
		for (int i = p.y; i < p.y + dy; i++) {
			for (int j = p.x; j < p.x + dx; j++) {
				map[i][j] = obj.getID() * 10000 + objects[obj.getID() - 1];
			}
		}
		objects[obj.getID() - 1] += 1;
		console.build(obj.getID());

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
	
	public void putObjectOn(GameObject obj, int x, int y) {
		GameObject temp = new GameObject();
		temp.copyFromGameObject(obj);
		gameArea.add(temp);
		temp.setLocation(x * spaceSide, y * spaceSide);
		allObjects.add(temp);
		signObjects();
		map[x][y] = obj.getID();
	}
	
	public void signObjects() {
		for (int i = 0; i < allObjects.size(); i++) {
			allObjects.get(i).setObjId(i);
		}
	}
	
	public Point formatPosition(Point prePoint) {
		int x;
		int y;
		x = prePoint.x / spaceSide;
		y = prePoint.y / spaceSide;
		Point p = new Point(x, y);
		return p;
	}
	
	public void generateMouseObj(int x, int y) {
		mouseObj = new JPanel();
		mouseObj.setSize(x * spaceSide, y * spaceSide);
		mouseObj.setBackground(Color.gray);
		mouseObj.setLocation(0, 0);
		gameArea.add(mouseObj);
	}
	
	class mapMouseMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			if (mouseIsHoldingSth) {
				Point p = gameArea.getMousePosition();
				p = formatPosition(p);
				mouseObj.setLocation(p.x * spaceSide, p.y * spaceSide);
			}
		}
		
	}
	
	class mapMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(mouseIsHoldingSth) {
				Point p = gameArea.getMousePosition();
				Point pp = formatPosition(p);
				GameObject puttingItem = null;
				for (int i = 0; i < objectMap.size(); i++) {
					if (objectMap.get(i).getID() == holdingItemID) {
						puttingItem = objectMap.get(i);
						break;
					}
				}
				
				System.out.println(holdingItemID);
				putObjectOn(puttingItem, pp);
				
				mouseObj.setVisible(false);
				gameArea.remove(mouseObj);
				mouseIsHoldingSth = false;
			} else {
				Point p = gameArea.getMousePosition();
				p = formatPosition(p);
				System.out.println(p);
				switch (map[p.y][p.x] / 10000) {
				case 1:
					lName.setText("Name: " + "Wall" + " #" + map[p.y][p.x] % 10000);
					String[] info = console.getWallInformationOf(map[p.y][p.x] % 10000);
					lPrice.setText("Price: " + info[0]);
					lMCost.setText("Maintaince Cost: " + info[1]);
					lCapacity.setText("Capacity: N/A");
					lDuration.setText("Duration: " + info[2]);
					lRange.setText("Range: N/A");
					break;
				case 2:
					lName.setText("Name: " + "Energy Generator" + " #" + map[p.y][p.x] % 10000);
					String[] info1 = console.getEnergyInformationOf(map[p.y][p.x] % 10000);
					lPrice.setText("Price: " + info1[0]);
					lMCost.setText("Maintaince Cost: " + info1[1]);
					lCapacity.setText("Capacity: " + info1[2]);
					lDuration.setText("Duration: " + info1[3]);
					lRange.setText("Range: " + info1[4]);
					break;
				case 3:
					lName.setText("Name: " + "Oxygen" + " #" + map[p.y][p.x] % 10000);
					String[] info11 = console.getOxygenInformationOf(map[p.y][p.x] % 10000);
					lPrice.setText("Price: " + info11[0]);
					lMCost.setText("Maintaince Cost: " + info11[1]);
					lCapacity.setText("Capacity: " + info11[2]);
					lDuration.setText("Duration: " + info11[3]);
					lRange.setText("Range: " + info11[4]);
					break;
				case 4:
					lName.setText("Name: " + "Water" + " #" + map[p.y][p.x] % 10000);
					String[] info111 = console.getWaterInformationOf(map[p.y][p.x] % 10000);
					lPrice.setText("Price: " + info111[0]);
					lMCost.setText("Maintaince Cost: " + info111[1]);
					lCapacity.setText("Capacity: " + info111[2]);
					lDuration.setText("Duration: " + info111[3]);
					lRange.setText("Range: " + info111[4]);
					break;
				case 5:
					lName.setText("Name: " + "Food" + " #" + map[p.y][p.x] % 10000);
					String[] info1111 = console.getFoodInformationOf(map[p.y][p.x] % 10000);
					lPrice.setText("Price: " + info1111[0]);
					lMCost.setText("Maintaince Cost: " + info1111[1]);
					lCapacity.setText("Capacity: " + info1111[2]);
					lDuration.setText("Duration: " + info1111[3]);
					lRange.setText("Range: " + info1111[4]);
					break;
				default:
					lName.setText("Name");
				}
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}

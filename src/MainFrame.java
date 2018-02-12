import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4731035233227046365L;
	private JButton btUpLeft, btUpRight, btDownLeft, btDownRight, btLeft, btRight, btCenter,
	btUp, btDown, btEnLarge, btShrink, btFaster, btSlower, btOriginalSize;
	private JLabel lblDelay;
	private static JComboBox<String> cbColor;
	private static Ball ball = new Ball();
	private static Timer timer;
	private int delay = 50;

	
	public MainFrame() {
		setFrameConfigurations();
		
		setButtonsPrefrences();
		
		arrangeComponents();

		setButtonsActionListeners();
		
		setFocus();
		
		addKeyListener(new KeyAdapter() {
			public void KeyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_ENTER: ball.Center();
						break;
					case KeyEvent.VK_DOWN: ball.Down();
						break;
					case KeyEvent.VK_UP: ball.Up();
						break;
					case KeyEvent.VK_LEFT: ball.Left();
						break;
					case KeyEvent.VK_RIGHT: ball.Right();
						break;
					case KeyEvent.VK_HOME: ball.Up(); ball.Left();
						break;
					case KeyEvent.VK_END: ball.Down(); ball.Left();
						break;
					case KeyEvent.VK_PAGE_UP: ball.Up(); ball.Right();
						break;
					case KeyEvent.VK_PAGE_DOWN: ball.Down(); ball.Right();
						break;
					case KeyEvent.VK_SUBTRACT: ball.shrink();
						break;
					case KeyEvent.VK_ADD: ball.enLarge();
						break;
					default: ;
				
				}
			}
		});

	}

	private void setFocus() {
		setFocusable(true);
		requestFocusInWindow();	
	}

	
	private void setFrameConfigurations() {
		setTitle("RedBall");
		setSize(new Dimension(700, 700));
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setAlwaysOnTop(true);
	}
	
	
	private void setButtonsPrefrences() {
		btUpLeft = new JButton("Up Left");
		btUpRight = new JButton("Up Right");
		btDownLeft = new JButton("Down Left");
		btDownRight = new JButton(" DownRight");
		btLeft = new JButton("Left");
		btRight = new JButton("Right");
		btCenter = new JButton("Center");
		btUp = new JButton("Up");
		btDown = new JButton("Down");
		btEnLarge = new JButton("EnLarge");
		btShrink = new JButton("Shrink");
		btFaster = new JButton("Faster");
		btSlower = new JButton("Slower");
		btOriginalSize = new JButton("Original Size");
		lblDelay = new JLabel("              Delay speed:  " + delay);
		
		cbColor = new JComboBox<String>(new String[] {"RED", "GREEN", "BLACK", "BLUE", "YELLOW"});
		
	}
	
	
	private void setButtonsActionListeners() {
		
		cbColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent changeColor) {
				int selected = cbColor.getSelectedIndex();
				ball.setColor(selected);
			}
		});
		
		btFaster.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent Faster) {
				delay -= 10;
				if (delay <= 0)
					delay = 1;
				
				lblDelay.setText("              Delay speed:  " + delay);
			}
		});
		
		btSlower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent Slower) {
				if(delay == 1)
					delay += 9;
				else
					delay += 10;
				lblDelay.setText("              Delay speed:  " + delay);
			}
		});
		
		btOriginalSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent shrink) {
				ball.OriginalSize();
			}
		});
		
		btShrink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent shrink) {
				ball.shrink();
			}
		});
	
		btEnLarge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent enlarge) {
				ball.enLarge();
			}
		});
		
		btUpLeft.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Up();
						ball.Left();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Up();
				ball.Left();
			}
               
            public void mouseExited(MouseEvent e) {
            	btUpLeft.setText("Up Left");
            }

            public void mouseEntered(MouseEvent e) {
            	btUpLeft.setText("\u2196");
            }
            
        });
		
		btUp.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Up();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Up();
			}
               
            public void mouseExited(MouseEvent e) {
            	btUp.setText("Up");
            }

            public void mouseEntered(MouseEvent e) {
            	btUp.setText("\u2191");
            }

        });
	
		btUpRight.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Up();
						ball.Right();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Up();
				ball.Right();
			}
               
            public void mouseExited(MouseEvent e) {
            	btUpRight.setText("Up Right");
            }

            public void mouseEntered(MouseEvent e) {
            	btUpRight.setText("\u2197");
            }
            
        });
		
		btLeft.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Left();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Left();
			}
               
            public void mouseExited(MouseEvent e) {
            	btLeft.setText("Left");
            }

            public void mouseEntered(MouseEvent e) {
            	btLeft.setText("\u2190");
            }
            
        });
		
		btCenter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent enlarge) {
				ball.Center();
			}
		});
		
		btRight.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Right();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Right();
			}
               
            public void mouseExited(MouseEvent e) {
            	btRight.setText("Right");
            }

            public void mouseEntered(MouseEvent e) {
            	btRight.setText("\u2192");
            }
            
        });
		
		btDownLeft.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Down();
						ball.Left();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Down();
				ball.Left();
			}
               
            public void mouseExited(MouseEvent e) {
            	btDownLeft.setText("Down Left");
            }

            public void mouseEntered(MouseEvent e) {
            	btDownLeft.setText("\u2199");
            }
            
        });
		
		btDown.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Down();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Down();
			}
               
            public void mouseExited(MouseEvent e) {
            	btDown.setText("Down");
            }

            public void mouseEntered(MouseEvent e) {
            	btDown.setText("\u2193");
            }
            
        });
		
		btDownRight.addMouseListener(new MouseListener(){ 
			public void mouseReleased(MouseEvent e) {
				if(timer != null){
					timer.cancel();
					timer = null;
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if(timer == null)
					timer = new java.util.Timer();

				timer.schedule(new TimerTask(){
					public void run(){
						ball.Down();
						ball.Right();
					}
				},1000,delay);
			}
			
			public void mouseClicked(MouseEvent e) {
				ball.Down();
				ball.Right();	
			}
			
            public void mouseExited(MouseEvent e) {
            	btDownRight.setText("Down Right");
            }

            public void mouseEntered(MouseEvent e) {
            	btDownRight.setText("\u2198");
            }
            
        });	
	
	}
	
	
	
	private void arrangeComponents() {
	   
		JPanel ButtonPnl = new JPanel();
	    ButtonPnl.setLayout(new GridLayout(4,4));
		
        setLayout(new BorderLayout());
	    this.add(ButtonPnl, BorderLayout.SOUTH);
	    
	    this.add(ball);
	    
	    ButtonPnl.add(btUpLeft);
	    ButtonPnl.add(btUp);
	    ButtonPnl.add(btUpRight);
	    ButtonPnl.add(btFaster);
	    ButtonPnl.add(btLeft);
	    ButtonPnl.add(btCenter);
	    ButtonPnl.add(btRight);
	    ButtonPnl.add(btSlower);
	    ButtonPnl.add(btDownLeft);
	    ButtonPnl.add(btDown);
	    ButtonPnl.add(btDownRight);
	    ButtonPnl.add(lblDelay);
	    ButtonPnl.add(btEnLarge);
	    ButtonPnl.add(btShrink);
	    ButtonPnl.add(btOriginalSize);
	    ButtonPnl.add(cbColor);
	}

}

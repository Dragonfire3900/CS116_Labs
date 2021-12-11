package FinalProj;

import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
	//Class defaults
	protected static final String DEF_NAME = "UNK";
	protected static final String DEF_INIT_PROMPT = "DEFAULT MENU PROMPT";
	protected static final InputStream DEF_SCAN_SRC = System.in;
	
	protected int nextActID = 0;
	
	protected HashMap<Integer, Runnable> actMap;
	protected HashMap<Integer, String> promptMap;
	protected String name;
	protected String initPrompt;
	protected Scanner sc;
	protected boolean looping = false;
	
	public Menu() {
		this.name = Menu.DEF_NAME;
		this.initPrompt = Menu.DEF_INIT_PROMPT;
		this.sc = new Scanner(Menu.DEF_SCAN_SRC);
		this.actMap = new HashMap<Integer, Runnable>();
		this.promptMap = new HashMap<Integer, String>();
	}
	
	public Menu(String nName, String nInitPrompt, Scanner sc) {
		if (nName.length() > 0) {
			this.name = nName;
		} else {
			this.name = Menu.DEF_NAME;
		}
		
		if (nInitPrompt.length() > 0) {
			this.initPrompt = nInitPrompt;
		} else {
			this.initPrompt = Menu.DEF_INIT_PROMPT;
		}
		
		if (sc != null) {
			this.sc = sc;
		} else {
			this.sc = new Scanner(Menu.DEF_SCAN_SRC);
		}
		
		this.actMap = new HashMap<Integer, Runnable>();
		this.promptMap = new HashMap<Integer, String>();
	}
	
	//Accessors
	public String getName() { return this.name; }
	
	public String getInitPrompt() { return this.initPrompt; }
	
	public String getPrompt(int id) throws NoSuchElementException {
		String output = this.promptMap.get((Integer) id);
		if (output == null) { throw new NoSuchElementException("That prompt string does not exist"); }
		return output;
	}
	
	protected Runnable getAct(int id) throws NoSuchElementException {
		Runnable output = this.actMap.get((Integer) id);
		if (output == null) { throw new NoSuchElementException("That runnable does not exist"); }
		return output;
	}
	
	//Mutators
	public void setInitPrompt(String nPrompt) {
		if (nPrompt.length() > 0) {
			this.initPrompt = nPrompt;
		}
	}
	
	public void setPrompt(int id, String nPrompt) throws NoSuchElementException {
		if (nPrompt.length() > 0) {
			this.promptMap.replace((Integer) id, nPrompt);
		}
	}
	
	public void addAct(Runnable nAct, String nPrompt) {
		if (nAct != null && nPrompt.length() > 0) {
			this.actMap.put((Integer) this.nextActID, nAct);
			this.promptMap.put((Integer) this.nextActID, nPrompt);
			this.nextActID += 1;
		}
	}
	
	public void setLoop(boolean nLoop) {
		this.looping = nLoop;
	}
	
	//String manipulations
	@Override
	public String toString() {
		return String.format("Menu: %s, with %d actions available", this.name, this.actMap.size());
	}
	
	//Special functions
	public void process() {
		StringBuilder output = new StringBuilder();
		
//		output.append(this.initPrompt + "\n");
//		output.append("Please enter a number to select an action\n");
//		this.promptMap.forEach((id, nPrompt) -> output.append(String.format("%d) %s\n", id + 1, nPrompt)));
//		System.out.println(output.toString());
		
		do {
			output.append(this.initPrompt + "\n");
			output.append("Please enter a number to select an action\n");
			this.promptMap.forEach((id, nPrompt) -> output.append(String.format("%d) %s\n", id + 1, nPrompt)));
			System.out.println(output.toString());
			output.setLength(0);
			
			try {
				int id = this.sc.nextInt();
				this.getAct(id - 1).run();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid integer to select\n");
				this.sc.nextLine();
			} catch (NoSuchElementException e) {
				System.out.println("That was not a valid option to select\n");
			}
		} while (this.looping);
	}
}

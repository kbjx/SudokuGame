package kbjx.sudoku;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	private int[][] pole;
	private final String suddata = "sudoku.txt";
	private final String tempsave = "save.txt";

	public Data() {
		pole = new int[9][9];
	}

	// count number of saved games
	public int countGames() throws FileNotFoundException, IOException {
		File file = new File(suddata);
		Scanner in = new Scanner(file);
		int Snumb = 0;
		while (in.hasNextInt()) {
			Snumb = in.nextInt();
		}
		in.close();
		return Snumb;
	}

	// save created game
	public void create(int pole[][]) throws FileNotFoundException, IOException {
		FileWriter writer = new FileWriter(suddata, true);
		writer.write("\r\n");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				writer.write(Integer.toString((pole[i][j]) * -1) + " ");
			}
		}
		writer.write("\r\n");
		writer.write(Integer.toString(countGames() + 1));
		writer.close();
	}

	// scan for selected game
	public void newGame(int n) throws IOException {
		File file = new File(suddata);
		Scanner in = new Scanner(file);

		for (int i = 2; i < (n * 2); i++) {
			in.nextLine();
		}
		for (int j = 0; j < 9; j++) {
			for (int k = 0; k < 9; k++) {
				pole[j][k] = (in.nextInt());
			}
		}
		in.close();
	}

	// delete game
	public void deleteGame(int n) throws IOException {
		String tempSudoku;
		File file = new File(suddata);
		Scanner in = new Scanner(file);
		FileWriter writer = new FileWriter("tempFile.txt");
		for (int i = 2; i < (n * 2); i++) {
			tempSudoku = in.nextLine();
			writer.write(tempSudoku);
			writer.write("\r\n");
		}
		in.nextLine();
		int x = n;
		int y = 1;
		while (in.hasNextLine()) {
			tempSudoku = in.nextLine();
			if (y == 2) {
				writer.write(tempSudoku);
				writer.write("\r\n");
				writer.write(Integer.toString(x));
				writer.write("\r\n");
				y = 0;
				x++;
			}
			y++;
		}
		in.close();
		writer.close();
	}

	// save current game
	public void save(int[][] pole) throws FileNotFoundException, IOException {
		File file = new File(tempsave);
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(fo);
		output.writeObject(pole);
		output.close();
		fo.close();
	}

	// load current game
	public int[][] load() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(tempsave);
		ObjectInputStream input = new ObjectInputStream(fi);
		pole = (int[][]) input.readObject();
		input.close();
		fi.close();
		return pole;
	}

	// print whole array
	public void printPole() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(pole[i][j]);
			}
			System.out.println();
		}
	}

	// find out if save exist
	public boolean saveExist() {
		File file = new File(tempsave);
		if (file.exists() && !file.isDirectory())
			return true;
		else
			return false;
	}

	public int getPole(int i, int j) {
		return pole[i][j];
	}

	public int[][] getPole() {
		return pole;
	}

	public void setPole(int i, int j, int value) {
		this.pole[i][j] = value;
	}

	public void setPole(int[][] pole) {
		this.pole = pole;
	}

	public String getTempsave() {
		return tempsave;
	}

}
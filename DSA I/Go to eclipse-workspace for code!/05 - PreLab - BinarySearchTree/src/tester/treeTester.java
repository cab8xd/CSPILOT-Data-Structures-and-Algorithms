package tester;
/*Tester for post lab 6 DSA I*/
import java.util.ArrayList;
import java.util.List;
import tree.AVLTree;
import tree.BinarySearchTree;

import java.io.*;


public class treeTester {
	
	private static int NUM_TRIALS = 15;
	
	public static void main(String[] args) {
		

        // The name of the file to open.
        String fileName = "text2.txt";
        ArrayList<String> s = new ArrayList<String>(); 
        String s2[];
		ArrayList<Integer> toAdd = new ArrayList<Integer>();

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                s2 = line.split(" ");
                for(String c : s2) {
                	s.add(c);
                }
            } 
            //System.out.println(s.toString());

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
	
        }
		//Number of elements to be inserted
		int numElements = 500000;
		int time;
		int t;
		//Creating object
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		AVLTree<String> avl = new AVLTree<String>();
		
		//System.out.println("Print2");
		//for inserts
		List<Integer> tRAVL = new ArrayList<Integer>();
		List<Integer> tRBST = new ArrayList<Integer>();
		List<Integer> hRAVL = new ArrayList<Integer>();
		List<Integer> hRBST = new ArrayList<Integer>();
		
		List<Integer> tXAVL = new ArrayList<Integer>();
		List<Integer> tXBST =  new ArrayList<Integer>();
		List<Integer> hXAVL = new ArrayList<Integer>();
		List<Integer>  hXBST = new ArrayList<Integer>();
		
		//For search
		List<Integer> tRAVLs = new ArrayList<Integer>();
		List<Integer> tRBSTs = new ArrayList<Integer>();
		List<Integer> hRAVLs = new ArrayList<Integer>();
		List<Integer> hRBSTs = new ArrayList<Integer>();
		
		List<Integer>  tXAVLs =  new ArrayList<Integer>();
		List<Integer> tXBSTs =  new ArrayList<Integer>();
		List<Integer> hXAVLs = new ArrayList<Integer>();
		List<Integer> hXBSTs = new ArrayList<Integer>();
		
		//Trials begin
		
		//System.out.println("Print3");
		for(int n = 0; n < NUM_TRIALS; n ++) {
			System.out.println("Trial: " + n);
		
			//Starting timer
			t = (int) System.currentTimeMillis(); 
		
			//Adding string words to to BST
			for(int i=0; i<s.size(); i++) {
				bst.insert(s.get(i));
			}
			//Stopping timer
			time = ((int) System.currentTimeMillis()) - t;
			
			//Recording height
			tXBST.add(time);
			
			//Recording height
			hXBST.add(bst.height());
			
			
			//Adding to avl
			for(int i=0; i<s.size(); i++) {
				avl.insert(s.get(i));
				//System.out.print(toAdd.get(i));
			}
			//timing avl
			time = ((int) System.currentTimeMillis()) - t;
			tXAVL.add(time);
			
			//adding height
			hXAVL.add(avl.height());
	
		
			//System.out.println("			TESTING STRING FINDs on BST & AST");
			
			
			//Searches for the middle element
			//System.out.println("   			BST search");
			for(int i=0; i<s.size(); i++) {
				if(!bst.find(s.get(i))) {
					System.out.println("FATAL ERROR: Element " + i + " was not found in your tree!");
					System.exit(1);
				}
			}

			
			//timing bst
			time = ((int) System.currentTimeMillis()) - t;
			tXBSTs.add(time);
			
			//adding height
			hXBSTs.add(bst.height());
			
			
			
			//System.out.println("   			AVL search");
			for(int i=0; i<s.size(); i++) {
				if(!avl.find(s.get(i))) {
					System.out.println("FATAL ERROR: Element " + i + " was not found in your tree!");
					System.exit(1);
				}
			}
			
				//timing avl
				time = ((int) System.currentTimeMillis()) - t;
				tXAVLs.add(time);
				
				//adding height
				hXAVLs.add(avl.height());
		
			
			
			
			
			
			
			
			
			
			
			
			

			BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
			AVLTree <Integer> avl2 = new AVLTree<Integer>();

			
			for(int i=0; i<numElements; i++) {
				toAdd.add((int)(Math.random()*(numElements)+i)); //Possible Errors?
			}
			
			//System.out.println("Print4");
			
			
			//Adding to bst
			for(int i=0; i<numElements; i++) {
				bst2.insert(toAdd.get(i));
			}
			//timing bst2
			time = ((int) System.currentTimeMillis()) - t;
			tRBST.add(time);
			
			//adding height
			hRBST.add(bst2.height());
			
			
			//Adding to avl
			for(int i=0; i<numElements; i++) {
				avl2.insert(toAdd.get(i));
				//System.out.print(toAdd.get(i));
			}
			//timing avl
			time = ((int) System.currentTimeMillis()) - t;
			tRAVL.add(time);
			
			//adding height
			hRAVL.add(avl2.height());
	
		
			//System.out.println("			TESTING RANDOM FINDs on BST & AST");
			
			
			//Searches for the middle element
			//System.out.println("   			BST search");
			for(int i=0; i<numElements; i++) {
				if(!bst2.find(toAdd.get(i))) {
					System.out.println("FATAL ERROR: Element " + i + " was not found in your tree!");
					System.exit(1);
				}
			}

			
			//timing bst
			time = ((int) System.currentTimeMillis()) - t;
			tRBSTs.add(time);
			
			//adding height
			hRBSTs.add(bst2.height());
			
			
			
			//System.out.println("   			AVL search");
			for(int j = 0; j<numElements; j++) {
				if(!avl2.find(toAdd.get(j))) {
					System.out.println("FATAL ERROR: Element " + j + " was not found in your tree!");
					System.exit(1);
				}
			}
			
				//timing avl
				time = ((int) System.currentTimeMillis()) - t;
				tRAVLs.add(time);
				
				//adding height
				hRAVLs.add(avl2.height());
			
		}
		System.out.println("[Random] results");
		System.out.println("BST insert time" + tRBST.toString());
		System.out.println();
		System.out.println("AVL insert time" + tRAVL.toString());
		System.out.println();
		System.out.println("BST search time" + tRBSTs.toString());
		System.out.println();
		System.out.println("AVL search time" + tRAVLs.toString());
		System.out.println();
		System.out.println();
		System.out.println("BST insert height" + hRBST.toString());
		System.out.println();
		System.out.println("AVL insert height" + hRAVL.toString());
		System.out.println();
		System.out.println("BST search height" + hRBSTs.toString());
		System.out.println();
		System.out.println("AVL search height" + hRAVLs.toString());
		System.out.println();
		System.out.println("[String] results");
		System.out.println("BST insert time" + tXBST.toString());
		System.out.println();
		System.out.println("AVL insert time" + tXAVL.toString());
		System.out.println();
		System.out.println("BST search time" + tXBSTs.toString());
		System.out.println();
		System.out.println("AVL search time" + tXAVLs.toString());
		System.out.println();
		System.out.println();
		System.out.println("BST insert height" + hXBST.toString());
		System.out.println();
		System.out.println("AVL insert height" + hXAVL.toString());
		System.out.println();
		System.out.println("BST search height" + hXBSTs.toString());
		System.out.println();
		System.out.println("AVL search height" + hXAVLs.toString());
		
	
}
}

		
		
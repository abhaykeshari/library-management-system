import java.util.ArrayList;
import java.util.Scanner;
class Book{
	int bookId;
	String bookName;
	boolean isIssued= true;

	//constructor 
	Book(int bookId , String bookName ){
		this.bookId = bookId;
		this.bookName = bookName;
	}
}
public class libraryManagement{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Book> books = new ArrayList<>();

	public static void main(String[] args){
		int choice ;
		do{
			System.out.println("--- Library Management System ---");
			System.out.println("press 1 for add book");
			System.out.println("press 2 for display books");
			System.out.println("press 3 for issue book");
			System.out.println("press 4 for return book");
			System.out.println("press 5 for Exit");
			System.out.print("enter your choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1 -> {
                    addBook();
                    System.out.println("book added successfully");
					System.out.println();
                }
				case 2 -> {display(books);
					System.out.println();
				}
				
				case 3-> {	
					issueBook();
					
					System.out.println();
                }
				case 4->{
					returnBooks();
					
					System.out.println();
				}
				case 5 -> System.out.println("Exiting...");
				}	
		}while(choice!=5);
	}
	
	static ArrayList<Book> addBook(){
		System.out.print("Enter Book id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Book name: ");
		String name = sc.nextLine();
		books.add(new Book(id , name));
		return books;
	}
	static void display(ArrayList<Book> books){
		for(Book b : books){
			String issue =b.isIssued ? "available" : "not available";
			System.out.println("Book id: " + b.bookId +" Book Name: "+b.bookName+ " issue: "+ issue);
		}
	}
	static ArrayList<Book> issueBook(){
		System.out.print("enter book id: ");
		int id = sc.nextInt();
		for(Book b : books){
			if(b.bookId == id){
				if(b.isIssued != false){
					b.isIssued = false;
					System.out.println("book issued successfully");
				}
				else{
					System.out.println("book already issued");
				}
			}
			else{
			System.out.println("book not found");
			}
		}
		
		return books;
	}
	static ArrayList<Book> returnBooks(){
		System.out.print("enter book id: ");
		int id = sc.nextInt();
		for(Book b : books){
			if(b.bookId == id){
				if(b.isIssued != true){
					b.isIssued = true;
					System.out.println("book return successfully");
				}
				else{
					System.out.println("book already available");
				}
				
			}
			else{
				System.out.println("book not found");
			}
		}
		return books;
	}
}

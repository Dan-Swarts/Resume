package csci2081.L5;

public class Bookshelf {

    // variables:
    private Book[] books;
    private int nextEmpty = 0;

    // constructors:
    public Bookshelf(){
        this.books = new Book[20];
    }

    public Bookshelf(int size){
        this.books = new Book[size];
    }

    // methods:
    public boolean add(Book newBook){
        if(nextEmpty == books.length){
            return false;
        }
        else{
            books[nextEmpty] = newBook;
            nextEmpty++;
            return true;
        }
    }

    public Bookshelf getBooksByAuthor(String author){
        Bookshelf booksByAuthor = new Bookshelf(this.books.length);
        for(int i = 0; i < nextEmpty; i++){
            if(books[i].getAuthor().equals(author)){
                booksByAuthor.add(books[i]);
            }
        }
        return booksByAuthor;
    }

    public String toString(){
        String myString = "";
        for(int i = 0; i < nextEmpty; i++){
            myString += books[i].toString();
            myString += "\n";
        }
    return myString;
    }


    public static void main(String args[]){
        Bookshelf b1 = new Bookshelf();

        System.out.println(b1.add(new Book("1984","Orwell",8.9)));
        System.out.println(b1.add(new Book("12 Rules for Life", "Peterson",3.5)));
        System.out.println(b1.add(new Book("The Holy Bible", "God",5.9)));
        System.out.println(b1.add(new Book("Catch 22","Heller",3.6)));
        System.out.println(b1.add(new Book("The new Testament","God",4.2)));

        System.out.println(b1);

        System.out.println(b1.getBooksByAuthor("God"));
    }
}

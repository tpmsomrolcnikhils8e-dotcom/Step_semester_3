import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;
    public LibraryItem(String title) {
        this.title = title;
    }
    public abstract LocalDate getDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {
    public Book(String title) { super(title); }
    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14); // 14 days[cite: 1]
    }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7); // 7 days[cite: 1]
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3); // 3 days[cite: 1]
    }
}

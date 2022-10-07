import java.awt.*;
import java.util.*;

public class Notebook {
    private int id;
    private String RAM;
    private String HDD;
    private Color color;

    private static Set<Notebook> notebookSet;

    public Notebook(int id, String RAM, String HDD, Color color) {
        this.id = id;
        this.RAM = RAM;
        this.HDD = HDD;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return id == notebook.id && Objects.equals(RAM, notebook.RAM) && Objects.equals(HDD, notebook.HDD) && Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, RAM, HDD, color);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", RAM='" + RAM + '\'' +
                ", HDD='" + HDD + '\'' +
                ", color=" + color +
                '}';
    }

    static Set<Notebook> filter(int a) {
        Set<Notebook> filterSet;
        switch (a) {
            case 1:
                filterSet = new TreeSet<>(new Comparator<Notebook>() {
                    @Override
                    public int compare(Notebook o1, Notebook o2) {
                        if (o1.color.toString().length()==o2.color.toString().length()) return  0;
                        else if ((o1.color.toString().length() > o2.color.toString().length())) return 1;
                        else return -1;
                    }
                });
                filterSet = notebookSet;
                break;
            case 2:
                filterSet = new TreeSet<>(new Comparator<Notebook>() {
                    @Override
                    public int compare(Notebook o1, Notebook o2) {
                        if (o1.RAM.length()==o2.RAM.length()) return  0;
                        else if (o1.RAM.length()>o2.RAM.length()) return 1;
                        else return -1;
                    }
                });
                filterSet = notebookSet;
                break;
            case 3:
                filterSet = new TreeSet<>(new Comparator<Notebook>() {
                    @Override
                    public int compare(Notebook o1, Notebook o2) {
                        if (o1.HDD.length()==o2.HDD.length()) return  0;
                        else if (o1.HDD.length()>o2.HDD.length()) return 1;
                        else return -1;
                    }
                });
                filterSet = notebookSet;
                break;
            default:
                filterSet = new HashSet<Notebook>();
        }
        return filterSet;

    }

    public static void main(String[] args) {
        notebookSet = new HashSet<>();
        notebookSet.add(new Notebook(1,"ram1","Hdd1",Color.cyan));
        notebookSet.add(new Notebook(2,"ram2","Hdd2",Color.BLACK));
        notebookSet.add(new Notebook(3,"ram3","Hdd3",Color.BLUE));
        notebookSet.add(new Notebook(4,"ram4","Hdd0",Color.cyan));
        notebookSet.add(new Notebook(5,"ram5","Hd",Color.cyan));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Print filter setting\n" +
                "1 - filter Color (String length)\n" +
                "2 - filter HDD\n" +
                "3 - filter RAM");
        int a = scanner.nextInt();
        Set<Notebook> filt = filter(a);
        for (Notebook notebook : filt) {
            System.out.println(notebook);
        }
    }
}

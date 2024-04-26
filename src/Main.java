import java.util.Scanner;

public class Fourth {
    public static Scanner sc;


    // Ввод с головы (1-й элемент всегда head)- перемещение хвоста (tail - перемещается)
    public static Node createHead(int n){
        System.out.print("Введите 1-е число: ");
        Node head = new Node(sc.nextInt(),null);
        Node tail = head;
        for(int i=1;i<n;i++){
            System.out.print("Введите "+(i+1)+"-е число: ");
            tail.next = new Node(sc.nextInt(),null);
            tail = tail.next;
        }
        return head;
    }
    // Ввод с хвоста - перемещение хвоста
    public static Node createTail(Node head, int n){
        for(int i=0;i<n;i++){
            System.out.print("Введите "+(i+1)+"-е число: ");
            head = new Node(sc.nextInt(),head);
        }
        return head;
    }

    public static String toString(Node head, String result){
        Node ref=head;
        result="";
        while(ref.next!=null){
            result=result+ref.value+' ';
            ref=ref.next;
        }
        result=result+ref.value;
        return result;
    }
    public static Node addFirst(Node head){
        Node newElem = new Node(sc.nextInt(),null);
        newElem.next=head;
        return newElem;
    }

    public static void addLast(Node head){
        Node newElem = new Node(sc.nextInt(),null);
        Node ref1=new Node(0,null);
        Node ref = head;
        while(ref.next!=null){
            ref1=ref;
            ref=ref.next;
        }
        ref.next=newElem;
    }

    public static Node insert(Node head, int number){
        Node newNode = new Node (sc.nextInt(),null);
        Node ref2 = new Node (0,null);
        Node ref1 = head;
        int k = 1;
        while(ref1.next!=null && (k<number)){
            ref2 = ref1;
            ref1 = ref1.next;
            k++;
        }
        if(number==k+1){
            ref1.next=newNode;
        }else {
            ref2.next = newNode;
            newNode.next = ref1;
            if (number == 1) {
                head = newNode;
            }
        }
        return head;

    }

    public static Node removeFirst(Node head){
        head=head.next;
        return head;
    }

    public static void removeLast(Node head){
        Node ref = head;
        while(ref.next.next!=null){
            ref=ref.next;
        }
        ref.next=null;
    }

    public static Node remove(Node head, int number){
        Node ref1 = new Node(0,null);
        Node ref = head;
        for(int i=0;i<number-1;i++){
            ref1=ref;
            ref=ref.next;
        }
        Node newNode = new Node(ref.next.value,ref.next.next);
        if(number == 1) {
            return newNode;
        }else {
            ref1.next=newNode;
            return head;
        }
    }

    public static void createHeadRec(Node current, int n, Node tail){
        if(current.next!=null) {
            createHeadRec(current.next, n, tail);
        }
        else {
            if (n > 0) {
                n--;
                System.out.print("Введите " + (n + 1) + "-е число: ");
                current.next = new Node(sc.nextInt(), null);
                createHeadRec(current.next, n, tail);
            }
        }
    }

    public static Node createTailRec(Node head, int n){
        if(n>0){
            n--;
            System.out.print("Введите "+(n+1)+"-е число: ");
            head = new Node (sc.nextInt(),head);
            head = createTailRec(head, n);
        }
        return head;
    }

    public static String toStringRec(Node head, String result){
        Node ref=head;
        if(ref!=null){
            toStringRec(ref.next, result);
        }
        result=result+ref.value;
        return result;
    }

    public static void main(String[] args) {
        Node ref = new Node(0, null);
        int k = 0;
        sc = new Scanner(System.in);
        System.out.print("Введите сколько чисел хотите ввести методом createHead: ");
        Node head = createHead(sc.nextInt());
        System.out.println("Результат выполнения createHead(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.print("Введите сколько чисел хотите ввести методом createTail(): ");
        head = createTail(head, sc.nextInt());
        System.out.println("Результат выполнения createTail(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.println("Метод toString: " + toString(head, null));
        System.out.print("Введите число элементу метод addFirst(): ");
        head = addFirst(head);
        System.out.println("Результат выполнения addFirst(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.print("Введите число элементу метод addLast(): ");
        addLast(head);
        System.out.println("Результат выполнения addLast(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.print("Метод insert() введите номер вводимого: ");
        int number = sc.nextInt();
        System.out.print("Введите число элементу метод insert(): ");
        head = insert(head, number);
        System.out.println("Результат выполнения insert(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        head = removeFirst(head);
        System.out.println("Результат выполнения removeFirst(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        removeLast(head);
        System.out.println("Результат выполнения removeLast(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.print("Введите номер элемента которую хотите удалить методом remove(): ");
        remove(head,sc.nextInt());
        System.out.println("Результат выполнения remove(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.print("Введите сколько чисел хотите ввести методом createHeadRec: ");
        int n = sc.nextInt();
        if(n>0) {
            createHeadRec(head, n, null);
        }
        System.out.println("Результат выполнения createHeadRec(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.print("Введите сколько чисел хотите ввести методом createTailRec: ");
        n = sc.nextInt();
        if(n>0) {
            head = createTailRec(head, n);
        }
        System.out.println("Результат выполнения createTailRec(): ");
        ref = head;
        k = 0;
        while (ref != null) {
            k++;
            System.out.println(k + ": " + ref.value);
            ref = ref.next;
        }
        System.out.println("Метод toStringRec: " + toString(head, null));
    }
}

public class Text {
    public static void main(String[] args){
        GenericQueue<String> list = new GenericQueue<>();
        list.enqueue("TOM");
        System.out.println(list.getFirst());
        list.enqueue("mary");
        System.out.println(list);
        System.out.println(list.dequeue());
        System.out.println(list.dequeue());
        System.out.println(list);
    }
}

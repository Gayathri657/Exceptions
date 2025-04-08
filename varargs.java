import java.util.Arrays;

class varargs {
    public void sample(String... a) {

        System.out.println(Arrays.toString(a));
    }

}

class Main {
    public static void main(String[] args) {
        varargs x = new varargs();
        x.sample("Gayathri", "Pamarthi", "what are you upto");
    }
}

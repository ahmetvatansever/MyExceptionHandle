public class Errors {
    public static void main(String[] args) {

        //OutOfMemoryError : JVM bellek yetersizliği nedeniyle yeni nesneler oluşturamadığında ortaya çıkar.
        try {
            int[] largeArray = new int[Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("Caught OutOfMemoryError: " + e.getMessage());
        }


        //InternalError Örneği: JVM'de bir sorun oldugunda bu hata oluşur.
        try {
            throw new InternalError("This is an internal error");
        } catch (InternalError e) {
            System.out.println("Caught InternalError: " + e.getMessage());
        }


        
        //UnknownError Örneği: JVM bilinmeyen bir ciddi hata ile karşılaştığında ortaya çıkar. Bu hata nadiren görülür.
        try {
            throw new UnknownError("This is an unknown error");
        } catch (UnknownError e) {
            System.out.println("Caught UnknownError: " + e.getMessage());
        }

        
        //StackOverflowError Örneği : Bir iş parçacığının çağrı yığını dolduğunda ortaya çıkar. Genellikle sonsuz recursive çağrılar nedeniyle oluşur.
        try {
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError: " + e.getMessage());
        }
        
    }

    public static void recursiveMethod() {
        recursiveMethod();
    }
}

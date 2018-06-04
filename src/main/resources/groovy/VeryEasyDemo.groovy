package groovy

class VeryEasyDemo {

    static def logInvoke(String invoker) {
//        def stringBuilder = new StringBuilder();
//        stringBuilder.append("Hello ");
//        stringBuilder.append(invoker).append();
//        return stringBuilder.toString(", there is groovy world, I am invoked!");
        return invoker + ", there is groovy world, I am invoked!"
    }
}

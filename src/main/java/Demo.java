/**
 * @author Mr.Yuan
 * @since 2017/1/20.
 */
public class Demo {

    public void fun1() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
        }
    }

    public void fun2() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
            return;
        }
    }

    public void fun3() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
        } else {
            System.out.println("then");
        }
    }

    public void fun4() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
            return;
        } else {
            System.out.println("then");
        }
    }

    public void fun5() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
        } else {
            System.out.println("then");
            return;
        }
    }

    public void fun6() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
            return;
        } else {
            System.out.println("then");
            return;
        }
    }

    public void fun7() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
        } else {
            System.out.println("then");
        }
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
        } else {
            System.out.println("then");
        }
    }

    public void fun8() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("if");
            if (System.currentTimeMillis() % 2 == 1) {
                System.out.println("if");
            } else {
                System.out.println("then");
            }
        } else {
            System.out.println("then");
        }
    }

    public void fun9() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("1-if");
            if (System.currentTimeMillis() % 2 == 1) {
                System.out.println("1-1-if");
                if (System.currentTimeMillis() % 2 == 1) {
                    System.out.println("1-1-1-if");
                    if (System.currentTimeMillis() % 2 == 1) {
                        System.out.println("1-1-1-1-if");
                        if (System.currentTimeMillis() % 2 == 1) {
                            System.out.println("1-1-1-1-1-if");
                        } else {
                            System.out.println("then");
                        }
                    } else {
                        System.out.println("then");
                    }

                } else {
                    System.out.println("then");
                }
            } else {
                System.out.println("then");
            }
        } else {
            System.out.println("then");
        }

    }

    public void fun10() {
        if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("then");
        } else if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("else-if-1");
        } else if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("else-if-2");
        } else if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("else-if-3");
            return;
        } else if (System.currentTimeMillis() % 2 == 1) {
            System.out.println("else-if-4");
        } else {
            System.out.println("then");
        }

    }
}

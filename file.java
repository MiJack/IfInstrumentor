/**
 * @author Mr.Yuan
 * @since 2017/1/20.
 */
public class Demo {

    public void fun1() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");com.mijack.Log.log("1_then_end");
        }
    }

    public void fun2() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");
            return;
        }
    }

    public void fun3() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");com.mijack.Log.log("1_then_end");
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");com.mijack.Log.log("1_else_end");
        }
    }

    public void fun4() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");
            return;
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");com.mijack.Log.log("1_else_end");
        }
    }

    public void fun5() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");com.mijack.Log.log("1_then_end");
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");
            return;
        }
    }

    public void fun6() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");
            return;
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");
            return;
        }
    }

    public void fun7() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");com.mijack.Log.log("1_then_end");
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");com.mijack.Log.log("1_else_end");
        }
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("2_then_start");System.out.println("if");com.mijack.Log.log("2_then_end");
        } else {
            com.mijack.Log.log("2_else_start");System.out.println("then");com.mijack.Log.log("2_else_end");
        }
    }

    public void fun8() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("if");
            if (System.currentTimeMillis() % 2 == 1) {
                com.mijack.Log.log("1.1_then_start");System.out.println("if");com.mijack.Log.log("1.1_then_end");
            } else {
                com.mijack.Log.log("1.1_else_start");System.out.println("then");com.mijack.Log.log("1.1_else_end");
            }com.mijack.Log.log("1_then_end");
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");com.mijack.Log.log("1_else_end");
        }
    }

    public void fun9() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("1-if");
            if (System.currentTimeMillis() % 2 == 1) {
                com.mijack.Log.log("1.1_then_start");System.out.println("1-1-if");
                if (System.currentTimeMillis() % 2 == 1) {
                    com.mijack.Log.log("1.1.1_then_start");System.out.println("1-1-1-if");
                    if (System.currentTimeMillis() % 2 == 1) {
                        com.mijack.Log.log("1.1.1.1_then_start");System.out.println("1-1-1-1-if");
                        if (System.currentTimeMillis() % 2 == 1) {
                            com.mijack.Log.log("1.1.1.1.1_then_start");System.out.println("1-1-1-1-1-if");com.mijack.Log.log("1.1.1.1.1_then_end");
                        } else {
                            com.mijack.Log.log("1.1.1.1.1_else_start");System.out.println("then");com.mijack.Log.log("1.1.1.1.1_else_end");
                        }com.mijack.Log.log("1.1.1.1_then_end");
                    } else {
                        com.mijack.Log.log("1.1.1.1_else_start");System.out.println("then");com.mijack.Log.log("1.1.1.1_else_end");
                    }com.mijack.Log.log("1.1.1_then_end");

                } else {
                    com.mijack.Log.log("1.1.1_else_start");System.out.println("then");com.mijack.Log.log("1.1.1_else_end");
                }com.mijack.Log.log("1.1_then_end");
            } else {
                com.mijack.Log.log("1.1_else_start");System.out.println("then");com.mijack.Log.log("1.1_else_end");
            }com.mijack.Log.log("1_then_end");
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");com.mijack.Log.log("1_else_end");
        }

    }

    public void fun10() {
        if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_then_start");System.out.println("then");com.mijack.Log.log("1_then_end");
        } else if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_else_if_start_0");System.out.println("else-if-1");com.mijack.Log.log("1_else_if_end_0");
        } else if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_else_if_start_1");System.out.println("else-if-2");com.mijack.Log.log("1_else_if_end_1");
        } else if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_else_if_start_2");System.out.println("else-if-3");
            return;
        } else if (System.currentTimeMillis() % 2 == 1) {
            com.mijack.Log.log("1_else_if_start_3");System.out.println("else-if-4");com.mijack.Log.log("1_else_if_end_3");
        } else {
            com.mijack.Log.log("1_else_start");System.out.println("then");com.mijack.Log.log("1_else_end");
        }

    }
}

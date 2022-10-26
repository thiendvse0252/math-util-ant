/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiendv.mathutil.main;

import com.thiendv.mathutil.core.MathUtil;

/**
 *
 * @author thien
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("This message comes from the main() method");
        System.out.println("This jar file is build based on Ant in co-operating with JUnit");
        System.out.println("More over, this message comes from a US-Build's jar file");
        tryTDDFirst();
//        testFactorialGivenWrongArgumentThrowsException();

    }

    public static void testFactorialGivenWrongArgumentThrowsException() {
        //Test case #3: đưa data cà chớn, n âm, n quá lớn, hàm đc thiết kế ném về Exception
        //Thấy ngoại lệ mừng rơi nc mắt khi đưa vào -5
        //Thấy ngoại lệ xuất hiện như kỳ vọng => pass cái test => màu xanh
        System.out.println("Hope to see the Exception! Illegal Argument Exception");
        MathUtil.getFactorial(-5);
    }

    //viết để đùng thử kĩ thuật viết code kiểu TDD
    //gọi thử/dùng thử hàm chính bên core bên MathUtil
    //xem nó sai đúng ra sao, ở ngay mức khởi đầu viết hàm
    public static void tryTDDFirst() {

        //test case #1 (Tình huống kiểm thử hàm số 1/xài thử hàm):
        //- input: n=1;
        //- gọi hàm getFactorial(1)
        //- Hy vọng hàm trả về 1, vì 1!=1
        long expected = 1;
        long actual = MathUtil.getFactorial(1);
        System.out.println("Test 1! | Status: " + "Expected: "
                + expected + " | Actual: " + actual);

        //test case #2 (Tình huống kiểm thử hàm số 2/xài thử hàm lần 2):
        //- input: n=2;
        //- gọi hàm getFactorial(2)
        //- Hy vọng hàm trả về 2, vì 2!=2
        System.out.println("Test 2! | Status: " + "Expected: 2"
                + " | Actual: " + MathUtil.getFactorial(2));

        //compare actual vs expected coi giống nhau ko
        //giống -> hàm đúng vs test case đang test
        //sai -> bug rồi
        //Test case #3:
        //n=-5, -5!, hy vọng bị đập vào mặt câu, cà chớn, n invalid
        System.out.println("Test -5! | Status: " + "Expected: NGOẠI LỆ XUẤT HIỆN"
                + " | Actual: " + MathUtil.getFactorial(-5));
    }

}

//TEST CASE
//Là tình huống xài app/ kiểm thử app/ kiểm thử tính năng/màn hình
//chức năng/xử lí của app
//Test case là tình huống kiểm thử app/ chức năng mà khi đó ta phải
//- Đưa vào data mẫu/test
//- Gọi hàm để xử lí dữ liệu đưa vào
//- Đưa ra expected value ta mong chờ app trả ra
//sau đó chờ hàm/tính năng xử lí xong trả ra kết quả!!
//và ta nhìn kết quả so sánh vs kì vọng trc đó
//để kết luận hàm/tính năng ổn, TEST CASE PASSED

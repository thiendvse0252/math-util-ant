/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiendv.mathutil.core;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author thien
 */
public class MathUtilTest {

    //Ta đi test ngoại lệ, so sánh, đo lường ngoại lệ có xuất hiện ko khi đưa data cà chớn
    //thay vì compare expected value >< actual value
    //lúc này ta đi so sánh, ước lượng xem ngoại lệ có xuất hiện như actual ko
    //nếu có xh như kỳ vọng, sure, hàm thiết kế ngon
    //nếu ngoại lệ xuất hiện như kỳ vọng, thì màu xanh 
    
    
    
    @Test(expected = IllegalArgumentException.class)   //Exception.class thì vẫn pass vì Exception là cha của các ngoại lệ
    //.class vì exception xuất hiện là new 1 exception, mà new thuộc nhóm class 
    public void testFactorialGivenWrongArgumentThrowsException() {
        //Test case #3: đưa data cà chớn, n âm, n quá lớn, hàm đc thiết kế ném về Exception
        //Thấy ngoại lệ mừng rơi nc mắt khi đưa vào -5
        //Thấy ngoại lệ xuất hiện như kỳ vọng => pass cái test => màu xanh
        System.out.println("Hope to see the Exception! Illegal Argument Exception");
        MathUtil.getFactorial(25);
    }

    @Test
    public void testFactorialGivenRightArgumentReturnsWell2() {

        //Test case #4: n=3, hy vọng hàm trả về 6, thực tế ??
        Assert.assertEquals(6, MathUtil.getFactorial(3));

        //Test case #5: n=4, hy vọng hàm trả về 24, thực tế ??
        Assert.assertEquals(24, MathUtil.getFactorial(4));

        //Test case #6: n=5, hy vọng hàm trả về 120, thực tế ??
        Assert.assertEquals(120, MathUtil.getFactorial(5));
    }

    public MathUtilTest() {

    }

    //@Test ra lệnh cho thư viện JUnit mình đã add/import tự động generate ra hàm public static void main()
    //biến hàm tryJUnitComparison() thành hàm main()
    //và gửi main() này cho JVM chạy 
    //@Test --- main()
    //ko @Test thì class ko có main(), lấy gì mà chạy, no runable method
    @Test

    //coding convention - quy tắc viết code
    //tên hàm kiểm thử/ tên hàm của test script
    //phải nói lên ý nghĩa việc kiểm thử
    //tình huống này, ta muốn test làm getF() tham số tử tế
    //n = 0..20!!!
    public void testFactorialGivenRightArgumentReturnsWell() {
        //Test case #1: n=0, hy vọng hàm trả về 1
        //                   thực tế hàm trả về mấy, đoán xem !!!
        long expected = 1;
        long actual = MathUtil.getFactorial(0);
        //so sánh expected & actual, máy tự so, ko cần sout(), cực
        Assert.assertEquals(expected, actual);

        //Test case #2: n=1, hy vọng hàm trả về 1, thực tế ??
        Assert.assertEquals(1, MathUtil.getFactorial(1));

        //Test case #3: n=2, hy vọng hàm trả về 2, thực tế ??
        Assert.assertEquals(2, MathUtil.getFactorial(2));
    }

    @Test
    public void tryJUnitComparison() {
        //hàm này thử nghiệm việc so sánh EXPECTED & ACTUAL
        //coi sai đúng ra màu thế nào!!
        //ta đag xài hàm của thử viện JUnit nhưng ko xài bừa bãi mà phải viết theo quy tắc định trước 
        //quy tắc định trước nằm ở @ - annotation
        Assert.assertEquals(100, 100);
    }

    //Class này dev sẽ viết những câu lệnh dùng để test hàm của code chính, test các hàm của class MATHUTIL
    //Trong class này sẽ có các lời gọi hàm getFactorial()
    //Có những lệnh so sánh giữa EXPECTED and ACTUAL
    //giống mình đã làm test bên MAIN()
    //nhưng khác ở chỗ, SAI -> màu đỏ, ĐÚNG -> MÀU XANH
    //mắt ko cần nhìn các dòng output từ hàm SYStem.out cho mất sức - chỉ nhìn 2 màu xanh, đỏ
    //muốn có đc điều này ta sẽ dùng thêm các UNIT TESTING FRAMEWORK
    //Ví dụ: JUNIT, TestNG (Java)
    //       xUnit, MSTest, NUnit (C#)
    //       PHPUnit (PHP)  ...
    //Việc viết code để test code gọi là UNIT TESTING
    //Đoạn code trong class này dùng JUNIT/UNIT TESING FRAMEWORK để kiểm thử hàm code chính
    //đoạn code kiểm thử này dgl TEST SCRIPT
    //code dùng để test code (chính) đgl test script (DAO, DTO, Controller, ...)
    //Test script sẽ sử dụng các test case
    //Ví dụ viết code test hàm getFactorial() với các case n = -5, 0, 1...
    

    //QUY TẮC XANH ĐỎ
    //*Màu xanh: khi all test case phải cùng là xanh
    //tức là expected == actual cho all tình huống test
    //*Màu đỏ: chỉ cần 1 trong các case sai
    //Chỉ cần 1 cái expected != actual, kết luận mạnh tay, hàm sai quá sai
    //Ý nghĩa của quy tắc: nếu đã test, nếu đã liệt kê các test case, thì chúng phải
    //đúng hết, chỉ cần 1 thằng sai, hàm ko ổn định về việc return => hàm sai
    //đúng đúng hết - sai chỉ cần 1 thằng
    //EXPECTED == ACTUAL => case đúng, test case passed
    //EXPECTED != ACTUAL => case FAILED
    //Nếu expected là chính xác, hàm đã xử lí sai, bug
    //Cũng có khi expected, cái ta kỳ vọng sai!! Lỗi do QC tính toán bằng tay sai!!
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiendv.mathutil.core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.thiendv.mathutil.core.MathUtil.getFactorial;

/**
 *
 * @author thien
 */
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {

    //chuẩn bị bộ data , là mảng 2 chiều, 2 cột ứng vs expected và n dòng 
    //ứng vs các test case
    //mảng object, số thì dùng wrapper class - class gói các primitive
    //Integer -> int, long -> long
    //int a[] = {5, 10, 15, 20, 25};  //liệt kê các phần tử mảng cách
    //int b[][] = {{1,0}, {1,1}, {2,2}, {6,3}, {24,4}, {120,5}, {720,6}};
    @Parameterized.Parameters
    public static Object[][] initData() {    //static - vùng tĩnh nằm 1 chỗ, cái nào cũng
                                              //heap - vùng nằm tùy biến data
        return new Integer[][]{{1, 0}, //có thể truy cập
        {1, 1},
        {2, 2},
        {6, 3},
        {24, 4},
        {120, 5},
        {720, 6}};

    }
    //ta sẽ map/ánh xạ các cột của mỗi dòng, ví dụ dòng đầu tiên
    //có 2 cột là 1 0 => ta sẽ ánh xạ 1 vào expected, 0 vào biến n
    //

    @Parameterized.Parameter(value = 0)
    public long expected;  //map vào cột 0 của mảng
    @Parameterized.Parameter(value = 1)
    public int n; //map vào cột 1 của mảng

    @Test
    public void testFactorialGivenRightArgumentReturnsWell() {
//        Assert.assertEquals(expected, MathUtil.getFactorial(n));
        assertEquals(expected, getFactorial(n));  //dùng hàm này phải import static hàm getF()
        //từ class MathUtil
    }
}

//phân tích cách viết code cho phần test hàm getF() hôm bữa
//Assert.assertEqual(1, MathUtil.getFactorial(0));
//lệnh dùng để test
//method, lệnh này lặp đi lặp lại cho các data ta đưa vào
//để ta kiểm tra các tình huống xài hàm/test case
//ta thay data 1, 0 thành các data tương ứng khác
//ví dụ
//Expected n!
//1     0
//1     1
//2     2
//6     3
//24    4
//120   5
//720   6
//...
//Assert.assertEquals(???, MathUtil.getFactorial(???));
//Nếu ta có đc cách nào đó, mà tách đám data ra riêng 1 chỗ
//Sau đó từ từ nhồi/FEED data này vào câu lệnh test ở trên
//coi như chỉ cần 1 lệnh gọi test hàm, data cứ thế tuần tự đẩy vào

//Kĩ thuật đẩy data ra khỏi các câu lệnh test, sau đó nhồi nó vô câu lệnh test
//giúp rút gọn số câu lệnh test, dễ dàng kiểm tra tính thiếu đủ của các test case
//- Kĩ thuật này gọi là DDT - DATA DRIVEN TESTING
//viết code kiểm thử hướng theo tách data
//JUNIT FR hỗ trợ sẵn vụ tách data, duyệt vòng for trên data nhồi vào hàm tg ứng
//còn gọi 1 tên khác là: kiểm thử theo kiểu tham số hóa 
//- PARAMETERIZED
//Dấu ??? ở lệnh gọi hàm chính là tên biến sẽ dùng để nhận
//data từ tập data đã tách ra - CONVERT DATA thành biến
//Để chơi vs DDT cần
//- Bộ data test -> tách riêng
//- Các tham số ứng vs bộ data - chính là các biến dùng trích data ra
//- Nhồi các biến tg ứng này vào câu lệnh so sánh/gọi hàm
//Toàn bộ code trong class này đc viết ra dùng để test code chính bên src package
//Code đc viết ra dùng để đi test code khác
//thì code này đgl Test Script
//1 Test Script sẽ chứa nhiều code để test hàm chính
//1 Test Script sẽ chứa nhiều test case
//1 Test Script có thể xài 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiendv.mathutil.core;

/**
 *
 * @author thien
 */
//đây là class mô phỏng lại các hàm tiện ích /dùng chung cho mọi
//class khác, mô phỏng lại class tiện ích java.Math của JDK
//thường cái gì là đồ dùng chung/tiện ích, thường đc thiết kế là static
public class MathUtil {

    public static final double PI = 3.141592653589793;

//    Hàm tiện ích tính n! = 1.2.3...
//    Lưu ý/Quy ước:
//    ko tính giai thừa số âm
//    0!=1!=1
//    vì giai thừa tăng cực nhanh, nên 21! đã vượt 18 số 0
//    tràn kiểu long.
//    ta ko tính 21! trở lên
    public static long getFactorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Invalid n. n must be between 0..20");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        //sống sót đến đây, sure n=2...20!!
        //cấm ko xài else nữa khi hàm đã có return phía trước
        long product = 1;
        //biến cộng dồn, nhân dồn, biến con heo đất
        //acc/accumulation/gửi góp
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }

}
//CODING CONVENTION //Quy tắc viết code cty ép phải theo!!

//Ta học sơ về khái niệm TDD - Test Driven Development - Dành cho dev
//là kĩ thuật lập trình mà khi viết code phải viết luôn các bộ kiểm thử
//các test case/ viết luôn các đoạn code dùng thử hàm/class để kiểm tra 
//tính đúng đắn của hàm/class gia tăng chất lượng code/giảm thiểu công sức 
//tìm bug/ phát hiện bug sớm

//viết code kèm vs viết test cases
//viết code có ý thức viết luôn phần kiểm thử code/hàm/class
// development driven             test 
//nếu xài TDD, giúp ta đi vào quy trình CI
//sau khi có đc tên hàm
//ta viết luôn các tình huống xài app
//chấp nhận khi chạy hàm chạy sai - do code chưa xong
//sau đó ta tối ưu/ chỉnh sửa code để đảm bảo code chạy đúng!!
//Quá trình sai-đúng-sai-đúng diễn ra liên tục (cycle)

//Để làm TDD:
//1. Viết phác thảo prototype của hàm/class
//2. Viết các bộ kiểm thử/test cases là các đoạn code bổ sung thêm
//nhưng là code để xài hàm vừa viết, check xem hàm ổn ko
//3. Chạy thử hàm vs bộ test case vừa tạo, xem tình hình đúng sai ra sao
// sai -> refactor, sửa code
// đúng -> hoàn thiện tiếp code khác
// Liên tục như vậy

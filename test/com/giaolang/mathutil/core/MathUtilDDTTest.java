/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.giaolang.mathutil.core;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/**
 *
 * @author USER
 */
import static com.giaolang.mathutil.core.MathUtil.getFactorial;
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {

    //chuẩn bị data, mảng 2 chiều vì nó có n đưa vào và expected [2]
    //và có nhiều cặp như thế [7]
    //mảng 2 chiều [7][2]
    @Parameterized.Parameters
    public static Object[][] initData() {
//        int a[] = {5, 10, 15, 20, 25};
//        int b[][] = {{1, 0}, {1, 1}, {2, 2}, {6, 3}, {24, 4}, {120, 5}, {720, 6}};
//        int c[][] = {{1, 0},
//        {1, 1},
//        {2, 2},
//        {6, 3},
//        {24, 4},
//        {120, 5},
//        {720, 6}};

        return new Integer[][]{{1, 0},
        {1, 1},
        {2, 2},
        {6, 3},
        {24, 4},
        {120, 5},
        {720, 6}
        };
        

    }
    // xài wrapper class nếu chơi số, ví dụ Integer (int) và Long (long)
    
    //sau khi có bộ data qua mảng 2 chiều, JUnit sẽ tự lặp forr
    //để lôi ra từng cặp data (1, 0) (1, 1), (2, 2), (6, 3)...
    //nhồi cặp này vào trong hàm so sánh...
    //nhưng nhồi - cách nào, gán value này vào biến nào đó
    //gán vào biến - THAM SỐ HÓA PARAMETERIZED
    //TA SẼ MAP/ÁNH XẠ 2 CỘT ỨNG VỚI 2 BIẾN: CỘT 0 - EXPECTED
    //                                       CỘT 1 - N ĐƯA VÀO HÀM GETF()
    @Parameterized.Parameter(value = 0) //0 là cái expected ở mảng trên
    public long expected;
            
    @Parameterized.Parameter(value = 1) //1 là cái n ở mảng trên
    public int n;
    
    //test hoy vì đã có các test case và data
    @Test
    public void testFactorialGivenRightArgumentRetsWell(){
        assertEquals(expected, getFactorial(n));
        
    }

}
//CLASS NÀY SẼ CHỨA CODE DÙNG ĐỂ TEST CODE CHÍNH Ở BÊN CLASS MATHUTIL
//CLASS NÀY SẼ CHỨA CODE DÙNG ĐỂ TEST HÀM getF() coi hàm chạy đungs ko
//Code viết ra dùng để test code khác (hàm khác/class hác)
//thì đoạn code này, class này đc gọi tên là:TEST SCRIPT
//Trong test script sẽ có những tình huống xài app, đưa data cụ  thể vào
//chờ xem hàm xử lí kết quả có như kì vọng hay ko
//Một Test Script sẽ chưa nhiều TEST CASES
//                  mỗi test case ứng với 1 tình huống xài hàm

//Phân tích Test Script cũ - hôm qua kia
//Trong test script cũ xuất hiện bad smell, sự trùng lặp về câu lệnh
//dưới đây
//Assert.assertEquals(120, MathUtil.getFactorial(5));   
//lệnh so sánh giá trị, lệnh gọi hàm đc lặp đi lặp lại với mỗi bộ test cases
//Cũng hàm này, cũng lệnh này, nhưng nó phải viết lại cho các bộ data sau:
//Expected              n
//1                     0
//1                     1
//2                     2
//6                     3
//24                    4
//120                   5
//720                   6
//[7][2] 7 lầu mỗi lầu 2 phòng
//Có cách nào kiể thay 2 con số trong lệnh so sánh = 2 ??? nào đó
//Assert.assertEquals(???, MathUtil.getFactorial(???));   
//Assert.assertEquals(expected, MathUtil.getFactorial(n));   
//Nếu ta tách đc toàn bộ data trong các câu lệnh so sánh ở trên 
//ra 1 chỗ riêng biệt như hàng cột ở trên, sau đó
//ta chỉ viẹc pick/lấy/tỉa data này nạp dần vào/nhồi dần vào cái lệnh gọi hàm, thì ta sẽ đạt đc:
//- Code gọn gàng hơn ko bị trùng lặp
//- Nhìn tổng qua biết có bao nhiêu test case và liệu rằng chúng đã đủ hay chưa
//Kĩ thuật viết test script (câu lệnh test) mà tác biệt data ra khỏi
//lệnh so sánh đc gọi bằng nhưnxg tên sau:
//-PARAMETERIZED - THAM SỐ HÓA, BIẾN DATA RA 1 CHỖ, ĐẶT CHO CHÚNG CÁI TÊN BIẾN,
//LÁT HỒI NHỒI CHÚNG TRỞ LẠI LỆNH SO SÁNH
//-  ĐT - DÂT DRIVEN TESTING VIẾT CODE KIỂM THỬ THEO STYLE TÁCH DATA
//JUNIT FW HỖ TRỢ SẴN TA VỤ TÁCH DATA, DUYỆT VÒNG FOR TRÊN DATA
//NHỒI VÀO HÀM TƯƠNG ỨNG
//ĐỂ CHƠI VỚI ĐT, TA CẦN:
//-Tách data ra 1 chỗ - MẢNG
//-Map cái data này vào các biến tương ứng
//-nhồi các biến tương ứng này vào câu lệnh so sánh/gọi hàm

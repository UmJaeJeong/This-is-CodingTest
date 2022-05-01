package Binary;

import java.util.*;

public class FindPartsBinarySearch {

    //이진 탐색 소스코드 구현(반복문)
    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = (start + end)/2;

            //찾은 경우 중간점 인덱스 반환
            if(arr[mid] == target) return mid;
            //중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if(arr[mid] > target) end = mid-1;
            //중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid +1;
        }
        return -1;
    }

    //이진 탐색 소스코드 구현(재귀함수)
    public static int binarSearchRecursion(int[] arr, int target, int start, int end){

        if(start>end) return -1;
        int mid = (start+end)/2;
        if(arr[mid] == target) return 1;
        else if(arr[mid]<target) return binarSearchRecursion(arr, target, mid+1, end);
        else return binarSearchRecursion(arr, target, start, mid-1);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }

        //이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        //M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for(int i=0; i<m;i++){
            targets[i] = sc.nextInt();
        }

        //손님이 확인 요청한 부품 번호를 하나씩 확인
        for(int i=0; i<m;i++){
            //해당 부품이 존재하는지 확인
            int result = binarySearch(arr, targets[i],0,n-1);
            if(result !=-1)System.out.println("yes");
            else System.out.println("no");
        }
    }
}

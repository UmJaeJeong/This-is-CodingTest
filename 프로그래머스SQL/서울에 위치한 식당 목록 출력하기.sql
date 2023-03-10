-- info /review 테이블
--서울에 위취/
--식당 ID, 이름, 음식종류, 즐겨찾기,주소, 리뷰평균 점수 조회
-- 평균점수 소수점 세번째 자리에서 반올림
--평균 점수 내림차순 정렬 , 즐겨찾기수 내림차순

select a.rest_id, a.rest_name, a.food_type, a.favorites, a.address, round(avg(b.review_score),2) as score
from rest_info a
join rest_review b on a.rest_id = b.rest_id
group by a.rest_id, a.rest_name, a.food_type, a.favorites, a.address
having a.address like '서울%'
order by avg(b.review_score) desc, a.favorites desc

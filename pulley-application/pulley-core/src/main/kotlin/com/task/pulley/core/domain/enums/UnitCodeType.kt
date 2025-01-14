package com.task.pulley.core.domain.enums

enum class UnitCodeType(
    private val code: String,
    private val description: String,
) {

    UC1572("UC1572", "모수와 통계량 구별, 모집단과 표본"),
    UC1573("UC1573", "도수분포표, 히스토그램, 도수분포다각형 작성 및 해석"),
    UC1574("UC1574", "줄기-잎 그림 작성 및 해석"),
    UC1575("UC1575", "막대그래프, 원 그래프"),
    UC1576("UC1576", "중심 경향 척도 : 자료의 평균, 평균절대편차, 최빈값"),
    UC1577("UC1577", "산포도 : 자료의 범위, 사분위수, IQR"),
    UC1578("UC1578", "산포도 : 분산, 표준편차"),
    UC1579("UC1579", "다변량 자료, 분할표, 산점도, 공분산과 상관계수"),
    UC1503("UC1503", "합집합, 교집합 및 여집합"),
    UC1506("UC1506", "사건의 합집합, 교집합 및 여집합의 계산"),
    UC1510("UC1510", "기본 조건부 확률의 계산"),
    UC1513("UC1513", "세 개 이상 집합의 교집합"),
    UC1519("UC1519", "순열과 조합을 이용한 확률 계산"),
    UC1520("UC1520", "이산확률분포, 이산확률변수, 확률질량함수"),
    UC1521("UC1521", "연속확률분포, 연속확률변수, 확률밀도함수"),
    UC1523("UC1523", "확률변수의 기대값"),
    UC1524("UC1524", "확률변수의 분산, 표준편차"),
    UC1570("UC1570", "확률변수의 공분산과 상관계수"),
    UC1526("UC1526", "결합확률밀도함수"),
    UC1529("UC1529", "확률변수의 독립과 종속 여부 판단"),
    UC1534("UC1534", "이항분포 기본 계산, 이항분포의 평균 및 표준 편차"),
    UC1535("UC1535", "이항 공식, 이항분포를 사용하여 정확히 m번 성공할 확률 찾기"),
    UC1536("UC1536", "이항 공식, 이항분포를 사용하여 m번 이상 또는 미만 성공할 확률 찾기"),
    UC1537("UC1537", "비복원추출, 초기하분포, 초기하확률"),
    UC1539("UC1539", "정규분포, 정규분포의 확률밀도함수, 정규분포의 확률 계산"),
    UC1540("UC1540", "표준정규분포의 확률 계산하기"),
    UC1541("UC1541", "중심극한정리 : 표본 평균의 표본 분포"),
    UC1542("UC1542", "중심극한정리 : 이항 분포에 대한 정규 근사"),
    UC1548("UC1548", "모평균에 대한 신뢰구간"),
    UC1564("UC1564", "F분포"),
    UC1568("UC1568", "카이제곱분포, 자유도, 표본분산, 카이제곱 검정"),
    UC1580("UC1580", "표본추출 : 단순랜덤추출"),
    UC1581("UC1581", "표본추출 : 계통추출법"),
    UC1582("UC1582", "표본추출 : 표집틀(sampling frame)"),
    UC1583("UC1583", "실험단위, 인자, 반응변수, 처리"),
    UC1584("UC1584", "랜덤화, 블록화, 랜덤블록계획, 반복"),
    UC1571("UC1571", "SAS 명령어, 함수");

    companion object {
        fun fromCode(code: String): UnitCodeType? {
            return entries.first { it.code == code }
        }
    }
}

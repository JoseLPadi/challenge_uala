package com.example.challengeuala

import com.example.challengeuala.logic.SearchService
import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.repository.entities.Coord
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
class SearchServiceUnitTest {

    private lateinit var cities: List<City>
    @Before
    fun init(){
        cities = listOf(
            City("","aaaaab",0, Coord(1.1,1.1)),//0
            City("","aaab",0, Coord(1.1,1.1)),  //1
            City("","aac",0, Coord(1.1,1.1)),   //2
            City("","ad",0, Coord(1.1,1.1)),    //3
            City("","ae",0, Coord(1.1,1.1)),    //4
            City("","af",0, Coord(1.1,1.1)),    //5
            City("","ag",0, Coord(1.1,1.1)),    //6
            City("","ah",0, Coord(1.1,1.1)),    //7
            City("","b",0, Coord(1.1,1.1)),     //8
            City("","c",0, Coord(1.1,1.1)),     //9
            City("","d",0, Coord(1.1,1.1)),     //10
            City("","Ea",0, Coord(1.1,1.1)),    //11
            City("","Eb",0, Coord(1.1,1.1)),    //12
            City("","Ec",0, Coord(1.1,1.1)),    //13
            City("","Ed",0, Coord(1.1,1.1)),    //14
            City("","Ee",0, Coord(1.1,1.1)),    //15
            City("","f",0, Coord(1.1,1.1)),     //16
            City("","fa",0, Coord(1.1,1.1)),    //17
            City("","faa",0, Coord(1.1,1.1)),   //18
            City("","faaa",0, Coord(1.1,1.1)),  //19
            City("","fbaa",0, Coord(1.1,1.1)),  //20
            City("","fbb",0, Coord(1.1,1.1)),   //21
            City("","fc",0, Coord(1.1,1.1)),    //22
            City("","fe",0, Coord(1.1,1.1)),    //23
            City("","ff",0, Coord(1.1,1.1)),    //24
            City("","zaaa",0, Coord(1.1,1.1)),  //25
            City("","zaa",0, Coord(1.1,1.1)),   //26
            City("","za",0, Coord(1.1,1.1)),    //27
            City("","zzb",0, Coord(1.1,1.1)),   //28
            City("","zzb",0, Coord(1.1,1.1)),   //29
            City("","zzb",0, Coord(1.1,1.1)),   //30
            City("","zzb",0, Coord(1.1,1.1)),   //31
            City("","zzb",0, Coord(1.1,1.1)),   //32
            City("","zzz",0, Coord(1.1,1.1))    //33
        ).sortedBy { it.name.lowercase()  }
    }



    @Test
    fun `test searchMinPivote not found`() {
        val searchService = SearchService(cities)
        val result = searchService.searchMinPivote("bbb", 0 , cities.size-1)
        assertEquals(0, result)
    }

    @Test
    fun `test searchMinPivote empty string`() {
        val searchService = SearchService(cities)
        val result = searchService.searchMinPivote("", 0 , cities.size-1)
        assertEquals(0, result)
    }
    @Test
    fun `test searchMinPivote min pivote lower and upper case`() {
        val searchService = SearchService(cities)
        val textUper="eb"
        val textLower= "zzb"
        val uper = searchService.searchMinPivote(textUper, 0 , cities.size-1)
        val lower = searchService.searchMinPivote(textLower, 0 , cities.size-1)
        assert(cities[uper].name.lowercase().startsWith(textUper) && !cities[uper-1].name.lowercase().startsWith(textUper) )
        assert(cities[lower].name.lowercase().startsWith(textLower) && !cities[lower-1].name.lowercase().startsWith(textLower) )
    }
    @Test
    fun `test searchMinPivote min frontier`() {
        val searchService = SearchService(cities)
        val result = searchService.searchMinPivote("aaaaab", 0 , cities.size-1)
        assertEquals(0, result)
    }


    @Test
    fun `test searchMaxPivote not found`() {
        val searchService = SearchService(cities)
        val result = searchService.searchMaxPivote("bbb", 0 , cities.size-1)
        assertEquals(-1, result)
    }

    @Test
    fun `test searchMaxPivote empty string`() {
        val searchService = SearchService(cities)
        val result = searchService.searchMaxPivote("", 0 , cities.size-1)
        assertEquals(cities.size-1, result) // "fa" está en la posición 17
    }
    @Test
    fun `test searchMaxPivote max pivote lower and upper case`() {
        val searchService = SearchService(cities)
        val textUper = "eb"
        val textLower = "zzb"
        val uper = searchService.searchMaxPivote(textUper, 0 , cities.size-1)
        val lower = searchService.searchMaxPivote(textLower, 0 , cities.size-1)
        assert(cities[uper].name.lowercase().startsWith(textUper) && !cities[uper+1].name.lowercase().startsWith(textUper) )
        assert(cities[lower].name.lowercase().startsWith(textLower) && !cities[lower+1].name.lowercase().startsWith(textLower) )

    }
    @Test
    fun `test searchMaxPivote min frontier`() {
        val searchService = SearchService(cities)
        val result = searchService.searchMaxPivote("zzz", 0 , cities.size-1)
        assertEquals(cities.size-1, result)
    }


    @Test
    fun `test searchElementStartWith frontiers`() {
        val searchService = SearchService(cities)
        val start = searchService.searchElementStartWith("aaaaab", 0 , cities.size-1)
        val end = searchService.searchElementStartWith("zzz", 0 , cities.size-1)
        assertEquals(cities.size-1, end)
        assertEquals(0, start)
    }


    @Test
    fun `test searchElementStartWith mid value`() {
        val searchService = SearchService(cities)
        val test1="fa"
        val test2="zzb"
        val result1   = searchService.searchElementStartWith(test1, 0 , cities.size-1)
        val result2   = searchService.searchElementStartWith(test2, 0 , cities.size-1)
        assert(cities[result1].name.lowercase().startsWith(test1))
        assert(cities[result2].name.lowercase().startsWith(test2))
    }


    @Test
    fun `test filterList not found`() {
        val searchService = SearchService(cities)
        val result1   = searchService.filterListfun("dderew")
        assert(result1.first==0 && result1.second==-1)
    }
    @Test
    fun `test filterList notFound char by char and return to empty string`() {
        val searchService = SearchService(cities)
        val st0 = ""
        val st1 = "f"
        val st2 = "fb"
        val st3 = "fbb"
        val st4 = "fbbb"
        val st5 = "fbbbe"
        val result1   = searchService.filterListfun(st1)
        val result2   = searchService.filterListfun(st2)
        val result3   = searchService.filterListfun(st3)
        val result4   = searchService.filterListfun(st4)
        val result5   = searchService.filterListfun(st5)
        val return4   = searchService.filterListfun(st4)
        val return3   = searchService.filterListfun(st3)
        val return2   = searchService.filterListfun(st2)
        val return1   = searchService.filterListfun(st1)
        val return0   = searchService.filterListfun(st0)


        assert(searchService.searchMinPivote(st1,0,cities.size-1) == result1.first &&
                searchService.searchMaxPivote(st1,0,cities.size-1) == result1.second)
        assert(searchService.searchMinPivote(st2,0,cities.size-1) == result2.first &&
                searchService.searchMaxPivote(st2,0,cities.size-1) == result2.second)
        assert(searchService.searchMinPivote(st3,0,cities.size-1) == result3.first &&
                searchService.searchMaxPivote(st3,0,cities.size-1) == result3.second)
        assert(searchService.searchMinPivote(st4,0,cities.size-1) == result4.first &&
                searchService.searchMaxPivote(st4,0,cities.size-1) == result4.second)
        assert(searchService.searchMinPivote(st5,0,cities.size-1) == result5.first &&
                searchService.searchMaxPivote(st5,0,cities.size-1) == result5.second)

        assert(searchService.searchMinPivote(st4,0,cities.size-1) == return4.first &&
                searchService.searchMaxPivote(st4,0,cities.size-1) == return4.second)
        assert(searchService.searchMinPivote(st3,0,cities.size-1) == return3.first &&
                searchService.searchMaxPivote(st3,0,cities.size-1) == return3.second)
        assert(searchService.searchMinPivote(st2,0,cities.size-1) == return2.first &&
                searchService.searchMaxPivote(st2,0,cities.size-1) == return2.second)
        assert(searchService.searchMinPivote(st1,0,cities.size-1) == return1.first &&
                searchService.searchMaxPivote(st1,0,cities.size-1) == return1.second)
        assert(searchService.searchMinPivote(st0,0,cities.size-1) == return0.first &&
                searchService.searchMaxPivote(st0,0,cities.size-1) == return0.second)

    }



}


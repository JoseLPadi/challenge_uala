package com.example.challengeuala.logic

import android.util.Log
import com.example.challengeuala.repository.entities.City

class SearchService(private val list:List<City>) {

    //two pivots, they will show the start and the finish filter.
    private var filteredStart =0
    private var filteredEnd = 0

    private var oldTextFilter:String = ""
    init {
        filteredEnd= list.size-1
    }
    /**
     * return a pair with init and finish position of the array that is filtered.
     */
    fun filterList(newTextFilter:String): Pair<Int, Int> {
        val startTime = System.currentTimeMillis()
        val result = filterListfun(newTextFilter)
        val endTime = System.currentTimeMillis()
        Log.d("timespend", result.toString())
        Log.d("timeSpend", "time: ${endTime-startTime}  -- string:${newTextFilter}")
        return result

    }

    internal fun filterListfun(newTextFilter:String): Pair<Int, Int> {
        val lowerCaseTextFilter = newTextFilter.lowercase()
        if (lowerCaseTextFilter.isEmpty()) {
            filteredStart=0
            filteredEnd=list.size-1
            return Pair(0, list.size-1)
        } else
            if (oldTextFilter.startsWith(lowerCaseTextFilter, true)) {
                val pair =Pair(
                    searchMinPivote(lowerCaseTextFilter, 0, filteredStart),
                    searchMaxPivote(lowerCaseTextFilter, filteredEnd, list.size-1))
                filteredEnd = pair.second
                filteredStart = pair.first
                return pair
            }
            // buscar con los pivotes filteredStart y filteredEnd
            else if (lowerCaseTextFilter.startsWith(oldTextFilter,true)) {
                val pos: Int = searchElementStartWith(lowerCaseTextFilter, filteredStart, filteredEnd)
                if (pos ==-1) return Pair(0,-1)
                else {
                    val pair = Pair(
                        searchMinPivote(lowerCaseTextFilter, filteredStart, pos + 1),
                        searchMaxPivote(lowerCaseTextFilter, pos - 1, filteredEnd)
                    )
                    return pair
                }
            }
        return Pair(0,0)
    }


    /**
     * textFilter is always lowercase
     */
    internal fun searchMinPivote(textFilter: String,start:Int, end:Int):Int {
        if( textFilter.isEmpty()) return start

        val mid = (start + end) / 2
        if (start >= end) return 0
        if (mid == start || mid == end){
            if (list[start].name.startsWith(textFilter, true)) {
                return start
            } else  if (list[end].name.startsWith(textFilter, true)) {
                return end
            }else
                return 0
        } else
        if (list[mid].name.startsWith(textFilter, true)) {
            if (mid!=0 && list[mid - 1].name.startsWith(textFilter, true)) {
                return searchMinPivote(textFilter, start, mid)
            } else return mid
        } else if (list[mid].name.lowercase() > textFilter)
            return searchMinPivote(textFilter, start, mid)
        else return searchMinPivote(textFilter, mid, end)
    }

    /**
     * textFilter is always lowercase
     */
    internal fun searchMaxPivote(textFilter: String,start:Int, end:Int):Int{
        if( textFilter.isEmpty()) return end
        val mid = (start + end) / 2
        if (start >= end) return -1
        if (mid == start || mid == end){
            if (list[start].name.startsWith(textFilter, true)) {
                return start
            } else  if (list[end].name.startsWith(textFilter, true)) {
                return end
            }else
                return -1
        } else
        if (list[mid].name.startsWith(textFilter,true)){
            if (mid<list.size-1 && list[mid+1].name.startsWith(textFilter,true)){
                return searchMaxPivote(textFilter, mid, end)
            } else return mid
        } else  if (list[mid].name.lowercase()>textFilter)
            return searchMaxPivote(textFilter, start, mid)
        else return searchMaxPivote(textFilter, mid, end)
    }


    internal fun searchElementStartWith(textFilter:String, start:Int, end:Int): Int {
        if (textFilter.isEmpty()) return start
        val mid = (start + end) / 2
        if (start >= end) return -1
        if (mid == start || mid == end) {
            if (list[start].name.startsWith(textFilter, true)) {
                return start
            } else if (list[end].name.startsWith(textFilter, true)) {
                return end
            } else
                return -1
        } else
            if (list[mid].name.startsWith(textFilter, true)) {
                return mid
            } else if (list[mid].name.lowercase() > textFilter)
                return searchElementStartWith(textFilter, start, mid)
            else return searchElementStartWith(textFilter, mid, end)
    }




}
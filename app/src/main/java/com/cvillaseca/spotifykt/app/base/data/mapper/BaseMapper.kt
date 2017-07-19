package com.cvillaseca.spotifykt.app.base.data.mapper

import java.util.ArrayList

abstract class BaseMapper<T1, T2> {

    abstract fun map1(o2: T2?): T1?

    abstract fun map2(o1: T1?): T2?

    fun map1(o2List: List<T2>?): List<T1> {
        var o1List: MutableList<T1>? = ArrayList()
        if (o2List != null) {
            o1List = ArrayList<T1>()
            var o1: T1?
            for (o2 in o2List) {
                o1 = map1(o2)
                if (o1 != null) {
                    o1List.add(o1)
                }
            }
        }
        return o1List as List<T1>
    }

    fun map2(o1List: List<T1>?): List<T2> {
        var o2List: MutableList<T2>? = ArrayList()
        if (o1List != null) {
            o2List = ArrayList<T2>()
            var o2: T2?
            for (o1 in o1List) {
                o2 = map2(o1)
                if (o2 != null) {
                    o2List.add(o2)
                }
            }
        }
        return o2List as List<T2>
    }
}
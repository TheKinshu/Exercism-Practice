(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [counter (count (str num))
        x (map read-string (seq (str num)))
        y (map read-string (repeat counter (str counter)))]
    (reduce + (map Math/pow x y))))

(defn armstrong-kelvin-03 [num]
  (let [counter (count (str num))
        x       (->> (str num)
                     (seq)
                     (map (comp read-string str)))
        y       (->> (str counter)
                     (repeat counter)
                     (map read-string))
        result  (map #(reduce * (repeat %2 %1)) x y)]
    (= (reduce + result) num)))

(armstrong-kelvin-03 0)
(armstrong? 5)
(armstrong? 10)
(armstrong? 153)
(armstrong? 100)
(armstrong? 9474)
(armstrong? 9475)
(armstrong? 9926315)
(armstrong? 9926314)
(armstrong-kelvin-03 21897142587612075)


(str 123)
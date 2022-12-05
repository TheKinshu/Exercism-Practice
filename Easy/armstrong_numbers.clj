(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [counter (count (str num))
        x (map read-string (seq (str num)))
        y (map read-string (repeat counter (str counter)))]
    (reduce + (map Math/pow x y))))

(armstrong? 0)
(armstrong? 5)
(armstrong? 10)
(armstrong? 153)
(armstrong? 100)
(armstrong? 9474)
(armstrong? 9475)
(armstrong? 9926315)
(armstrong? 9926314)
(armstrong? 21897142587612075)
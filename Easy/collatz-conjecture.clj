(ns collatz-conjecture)

(defn collatz [num] ;; <- arglist goes here
  (loop [x num
         total 0]
    (cond
      (< x 1)    (throw "this number is negative")
      (= x 1)    total
      (even? x)  (recur (/ x 2) (inc total))
      :else      (recur (+ (* 3 x) 1) (inc total)))))


(collatz 16)
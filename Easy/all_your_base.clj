(ns all-your-base)

(defn decimal-binary [ls base]
  (loop [x (int (clojure.string/join ls))
         result []]
    (if (> x 0)
      (recur
       (int (/ x base))
       (conj result (rem x base)))  (reverse result))))

(defn binary-decimal [ls base]
  (loop [xs ls
         result []]
    (if xs
      (let [x (first xs) counter (- (count xs) 1)]
        (println counter)
        (recur (next xs) (conj result
                               (* x (Math/pow base counter)))))
      (reduce + result))))


(defn convert [currentBase ls newbase]
  (cond
    (<= newbase 0) nil
    (= currentBase 10) (decimal-binary ls newbase)
    (= currentBase 2) (binary-decimal ls currentBase)
    (= currentBase 7) (binary-decimal ls currentBase)
    :else nil))

(convert 2 '(1) 10)
(convert 10 (quote (4 2)) 2)
(convert 10 '(5) 2)
(convert 2 (quote (1 0 1)) 10)
(convert 10 (quote (0 0 0)) 2)
(convert 7 '(0 6 0) 10)
(convert 10 '(1) 10)

(binary-decimal (quote (0 0 0)) 10)
(quote (5))


;;convert base 7 to base 10
;;(7 '(0 6 0) 10)
(* 0 (Math/pow 7 2))
(* 6 (Math/pow 7 1))
(* 0 (Math/pow 7 0))

;;convert base 97 to base 73

;;convert base 3 to base 16
;;    (is (= '(1 1 2 0) (all-your-base/convert 16 '(2 10) 3)))))
(* 2 (Math/pow 16 1))
(* 10 (Math/pow 16 0))





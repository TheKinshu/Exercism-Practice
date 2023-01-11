(ns all-your-base (:require [clojure.string :as string]))

(defn binary-decimal [ls base]
  (loop [xs ls
         result []]
    (if xs
      (let [x (first xs)
            counter (-> (count xs)
                        (- 1))]
        (recur
         (next xs)
         (conj result
               (* x (Math/pow base counter)))))
      ;; result when xs is true
      (->> (reduce + result)
           (int)
           (str)
           seq
           (map (comp read-string str))))))

(defn decimal-binary [ls base]
  (loop [x (->> (reduce str ls)
                (str)
                (Integer/parseInt))
         result []]
    (if (> x 0)
      (recur
       (int (/ x base))
       (conj result (rem x base)))

      (if (= (reverse result) ()) '(0) (reverse result)))))

(defn both [base ls newbase]
  (let [to-dec (binary-decimal ls base)
        to-bin (decimal-binary to-dec newbase)]
    to-bin))

(defn check-negative [ls]
  (loop [xs ls
         result []]
    (if xs
      (let [x (first xs)]
        (recur
         (next xs)
         (if (or (> x 1) (< x 0)) (conj result 1) (conj result 0))))
      (reduce + result))))

(defn convert [base ls newbase]
  (cond
    (empty? ls) nil
    (< newbase 2) nil
    (< base 0) nil
    (= base 0) 0
    (and (= base 2) (> (check-negative ls) 0)) nil
    (or (= base 7) (= base 2)) (binary-decimal ls base)
    (= base 10) (decimal-binary ls newbase)

    :else (both base ls newbase)))
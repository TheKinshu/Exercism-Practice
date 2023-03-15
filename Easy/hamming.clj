(ns hamming (:require [clojure.string :as string]))

(defn compare-string [strand1 strand2]
  (->> (map = strand1 strand2)
       (filter false?)
       (count)))

(defn distance [strand1 strand2] ; <- arglist goes here
  ;; your code goes here
  (let [str1 (count strand1)
        str2 (count strand2)]
    (cond
      (not (= str1 str2)) nil
      (= 0 (compare strand1 strand2)) 0
      :else (compare-string strand1 strand2))))

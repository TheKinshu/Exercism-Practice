(ns robot-name (:require [clojure.string :as string]))

(defn rand-str []
  (->> (repeatedly #(char (+ (rand 26) 65)))
       (take 2)
       (apply str)))

(defn rand-num []
  (->> (repeatedly #(rand-int 10))
       (take 3)
       (apply str)))

(defn new-name [] ;; <- arglist goes here
  ;; your code goes here
  (->> (rand-num)
       (str (rand-str))))

(defn robot [] ;; <- arglist goes here
  ;; your code goes here
  {:name (atom (new-name))})

(defn robot-name [robot] ;; <- arglist goes here
      ;; your code goes here
  (deref (robot :name)))

(defn reset-name [robot] ;; <- arglist goes here
  ;; your code goes here
  (reset! (robot :name) (new-name)))
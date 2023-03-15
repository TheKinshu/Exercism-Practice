(ns pangram (:require [clojure.set :as set]
                      [clojure.string :as string]))

(def alphabet "abcdefghijklmnopqrstuvwxyz")

(defn pangram? [data] ;; <- arglist goes here
  ;; your code goes here
  (let [lower (string/lower-case data)]
    (->> (set alphabet)
         (set/superset? (set lower)))))
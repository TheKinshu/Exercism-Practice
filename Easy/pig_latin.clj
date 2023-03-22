(ns pig-latin (:require [clojure.set :as cset]
                        [clojure.string :as string]))

(def patterns
  [#"((?:[aeiou]|xr|yt).*)"
   #"([bcdfghjklmnpqrstvwxz]+)(y.*)"
   #"([bcdfghjklmnprstvwxyz]*qu)(.*)"
   #"([^aeiou]+)(.*)"])

(defn convert [data]
  (-> (some #(re-matches % data) patterns)
      (rest)
      (reverse)
      (string/join)
      (str "ay")))

(defn translate [phrase]
  (->> (string/split phrase #"\s")
       (map convert)
       (string/join " ")))

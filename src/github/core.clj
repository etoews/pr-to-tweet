(ns github.core
  (:require
    [clojure.edn :as edn]))

(defn load-github-config
  "Load and return your GitHub configuration.
   Copy github.edn.template to github.edn and edit."
  ([] (load-github-config "resources/github.edn"))
  ([filename]
  (try
    (edn/read-string (slurp filename))
    (catch java.io.FileNotFoundException e
      (throw (java.io.FileNotFoundException.
              (str (.getMessage e) " Copy github.edn.template to github.edn and edit.")))))))

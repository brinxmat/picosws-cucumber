# Autoritetsregister for verk

## SIPOC

Her bruker jeg ordet "biblioteksystem" ukritisk, det kunne like gjerne bare vært "tredjepartsdatakonsumentapplikasjon"

| Supplier | Input | Process | Output | Customer |
|----------|-------|---------|--------|----------|
| Biblioteksystem | Autoritets-ID, ønsket format | Finn data i riktig format | Formatert data | Bibliotekssystem |
| Biblioteksystem | Streng | Finn treff i database | Treffliste | Biblioteksystem |
| Biblioteksystem | Autoritetsdata | Opprette nytt autoritet | Statuskode, (autoritets-ID) | Biblioteksystem |
| Biblioteksystem | Autoritetsdata, Etag | Endre autoritetsdata | Statuskode | Biblioteksystem |


# Utviklingspipeline



# Utviklingsprosess




![a](http://www.growing-object-oriented-software.com/figures/tdd-with-acceptance-tests.svg)


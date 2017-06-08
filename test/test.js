
// obv class which is the object they pass in to droidguard constructor
var obv = Java.registerClass({
  name: 'obv',
  methods: {
    getName: {
      returnType: 'java.lang.String',
      argumentTypes: [],
      implementation: function () {
        return 'Fred';
      },
    },
  }
});